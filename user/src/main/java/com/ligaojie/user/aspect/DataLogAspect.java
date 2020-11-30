package com.ligaojie.user.aspect;


import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ligaojie.user.entity.Action;
import com.ligaojie.user.entity.ChangeItem;
import com.ligaojie.user.entity.DiffUtil;
import com.ligaojie.user.mapper.ActionTestDao;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class DataLogAspect {
	
//	private static final Logger logger =LoggerFactory.getLogger(DataLogAspect.class);
//	@Autowired
//	private ProductDao productDao;
	
	@Autowired
	private ActionTestDao actionDao;
	
	//execution(* com.baozun.promotion.service..*(..))
	@Pointcut("execution(* com.ligaojie.user.service..*(..))")
	public void save() {
		
	}
	
	@Pointcut("execution(public * com.ligaojie.user.*.delete*(..))")
	public void delete() {
		
	}
	@Around("save() || delete()")
	public Object addOperateLog(ProceedingJoinPoint pjp) throws Throwable{
	
		log.info(pjp.toLongString());
		System.err.println("enter aspect");
		Object returnObject = null;
		String methodName = pjp.getSignature().getName();
		
		Class<?> cls = pjp.getTarget().getClass();
	
		//1添加 2更新 3删除
		String actionType = null;
		
		Date operatorTime = new Date();
		Action action = new Action();
		Long idLong = null;
		Object oldObject = null;
		Object newObject = null;

		try {
			if ("insertProduce".equals(methodName)) {
				//insert || update
				Object object = pjp.getArgs()[0];
				Object property = PropertyUtils.getProperty(object, "id");
				//insert 
				if (null == property) {
					actionType = "1";
					List<ChangeItem> changeItems = DiffUtil.getInsertChangeItems(object);
					action.setActionType("1");
					action.getChanges().addAll(changeItems);
					action.setObjectClass(object.getClass().getName());

				}else {
					//update
					idLong = Long.parseLong(property.toString());
					action.setObjectId(idLong);
					Object target = pjp.getTarget();
					oldObject = DiffUtil.getObjectById(target, idLong);
					actionType = "2";
					action.setObjectClass(oldObject.getClass().getName());

				}
				
			}else if ("delete".equals(methodName)) {
				actionType = "3";
				oldObject = DiffUtil.getObjectById(pjp.getTarget(), idLong);
				ChangeItem changeItem = DiffUtil.getDeleteChangeItem(oldObject);
				action.getChanges().add(changeItem);
				//删除参数是 id
				action.setObjectId(Long.valueOf(pjp.getArgs()[0].toString()));
				action.setObjectClass(oldObject.getClass().getName());
				
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
			
		}
		action.setActionType(actionType);
		Object[] args = pjp.getArgs();
		Object proceed = pjp.proceed(args);
		Object object=args[0];
		//新值
		returnObject = null;
		
		if ("1".equals(actionType)) {
			Object newId = PropertyUtils.getProperty(object, "id");
			String string = newId.toString();
			action.setObjectId(Long.valueOf(newId.toString()));
			
		}else if ("2".equals(actionType)) {
			Object newObj = DiffUtil.getObjectById(pjp, idLong);
			List<ChangeItem> items = DiffUtil.getUpdateChangeItem(oldObject, newObj);
			action.getChanges().addAll(items);
		}
		
		action.setOperator("admin");//动态获取 
		action.setOperateTime(operatorTime);
		Action save = actionDao.save(action);
		System.err.println(save);
		System.out.println("====");
		return object;
		
	}
	
	

}
