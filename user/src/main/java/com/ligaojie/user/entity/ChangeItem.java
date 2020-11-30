package com.ligaojie.user.entity;
import com.ligaojie.user.myinterface.DataLog;

import lombok.Data;

@Data
public class ChangeItem {

	private String field;

//	private String fieldName;
	
	@DataLog(name = "产品啊")
	private String fieldShowName;

	private String oldValue;

	private String newValue;
	    

}
