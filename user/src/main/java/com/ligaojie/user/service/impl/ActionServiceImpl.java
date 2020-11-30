package com.ligaojie.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ligaojie.user.entity.Action;
import com.ligaojie.user.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService{
	
    @Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public Action findActionById(String id) {
	    Query query= new Query(Criteria.where("_id").is(id));  
		return mongoTemplate.findOne(query, Action.class);
	}

}
