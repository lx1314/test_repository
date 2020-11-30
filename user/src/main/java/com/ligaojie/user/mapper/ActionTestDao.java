package com.ligaojie.user.mapper;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ligaojie.user.entity.Action;

@EnableMongoRepositories
public interface ActionTestDao extends MongoRepository<Action, String>{

}
