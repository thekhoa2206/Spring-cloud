package com.sapo.coffeeshop.models.repository;

import com.sapo.coffeeshop.models.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySaveRepo extends CrudRepository<User, Long>, CustomizedSave<User> {

}
