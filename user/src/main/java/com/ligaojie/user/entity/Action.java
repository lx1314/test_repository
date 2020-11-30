package com.ligaojie.user.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "action")
public class Action {

    @Field("id")
	private String id;

	// 产品id
	private Long objectId;

	private String objectClass;

	private String operator;

	private Date operateTime;

	private List<ChangeItem> changes=new ArrayList<ChangeItem>();

	//1添加 2更新 3删除
	private String actionType;

}
