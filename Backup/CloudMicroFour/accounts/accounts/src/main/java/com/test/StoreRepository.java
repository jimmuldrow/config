package com.test;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, String> {
	Store findByKey(String key);
}