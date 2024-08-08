package com.example.CurdProjMangoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.CurdProjMangoDB.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
