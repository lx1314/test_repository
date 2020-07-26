package com.ligaojie.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "t_promo_activity")
public class TPromoActivityEntity {
	
	    @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private String id;

	    // 创建者
	    @Column(name = "CREATE_USER")
	    private String createUser;

	    // 创建时间
	    @Column(name = "CREATE_TIME")
	    private Date createTime;

	    // 更新者
	    @Column(name = "UPDATE_USER")
	    private String updateUser;

	    // 更新时间
	    @Column(name = "UPDATE_TIME")
	    private Date updateTime;

	    // 逻辑删除: 0-未删除 1-已删除
	    @Column(name = "LOGIC_DELETE")
	    private String logicDelete;

    /**
     * 系统租户编码，系统拥有者编码
     */
    @Column(name = "TENANT_CODE")
    private String tenantCode;

    /**
     * 活动编码
     */
    @Column(name = "ACTIVITY_CODE")
    private String activityCode;

    /**
     * 活动类型: 01-活动 02-券
     */
    @Column(name = "ACTIVITY_TYPE")
    private String activityType;

    /**
     * 活动分类标签
     */
    @Column(name = "ACTIVITY_LABEL")
    private String activityLabel;

    @Column(name = "ACTIVITY_URL")
    private String activityUrl;

    /**
     * 活动名称
     */
    @Column(name = "ACTIVITY_NAME")
    private String activityName;

    /**
     * 活动描述
     */
    @Column(name = "ACTIVITY_RULE_DESC")
    private String activityRuleDesc;

    /**
     * 活动描述
     */
    @Column(name = "ACTIVITY_DESC")
    private String activityDesc;

    /**
     *是否分摊标识
     */
    @Column(name = "PRICE_FLAG")
    private String priceFlag;
    
    /**
     * 活动备注
     */
    @Column(name = "ACTIVITY_REMARK")
    private String activityRemark;

    /**
     * 活动公式
     */
    @Column(name = "ACTIVITY_EXPR")
    private String activityExpr;

    /**
     * 扩展字段：外部编码（1.20版本新加）
     */
    @Column(name = "OUTER_ACTIVITY_CODE")
    private String outerActivityCode;
    
    /**
     * 是否对外显示：1显示；2不显示（1.21版本新加）
     */
    @Column(name = "SHOW_FLAG")
    private Integer showFlag;
    
    /**
     * 促销模板ID
     */
    @Column(name = "TEMPLATE_ID")
    private String templateId;

    /**
     * 奖励限制标志：0-无限制 1-有限制
     */
    @Column(name = "INCENTIVE_LIMITED_FLAG")
    private String incentiveLimitedFlag;

    /**
     * 预热开始时间：yyyyMMddhhmmss
     */
    @Column(name = "WARM_BEGIN")
    private String warmBegin;

    /**
     * 预热结束时间：yyyyMMddhhmmss
     */
    @Column(name = "WARM_END")
    private String warmEnd;

    /**
     * 开始时间：yyyyMMddhhmmss
     */
    @Column(name = "ACTIVITY_BEGIN")
    private String activityBegin;

    /**
     * 结束时间：yyyyMMddhhmmss
     */
    @Column(name = "ACTIVITY_END")
    private String activityEnd;

    /**
     * 活动状态：01-待提交 02-审核中 03-已拒绝 04-已生效 05-已结束 06-暂停中 07-已终止
     */
    @Column(name = "ACTIVITY_STATUS")
    private String activityStatus;

    /**
     * 商品范围：00-全商品 01-自定义
     */
    @Column(name = "PRODUCT_TYPE")
    private String productType;

    /**
     * 商品范围正反选：01-正选；02-反选
     */
    @Column(name = "PRODUCT_SELECTION_TYPE")
    private String productSelectionType;

    /**
     * 周期类型：00-全时段 01-自定义
     */
    @Column(name = "PERIOD_TYPE")
    private String periodType;

    /**
     * 活动优先级
     */
    @Column(name = "PRIORITY")
    private Integer priority;

    /**
     * 店铺范围：00-全店铺 01-自定义
     */
    @Column(name = "STORE_TYPE")
    private String storeType;

    /**
     * 价格类型：01-销售价 02-吊牌价,不填默认01.
     */
    @Column(name = "PRICE_TYPE")
    private String priceType;

    /**
     * 活动分组编码
     */
    @Column(name = "group_code")
    private String groupCode;

    /**
     * 是否支持资源释放：0-不支持 1-支持
     */
    @Column(name = "resource_flag")
    private String resourceFlag;
}