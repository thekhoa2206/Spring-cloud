package com.sapo.coffeeshop.models.repository;

import com.sapo.coffeeshop.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJPARepository3 extends JpaRepository<User, Integer> {
    @Procedure(name = "getUsers")
    List<User> getUserByQuery(@Param("Query") String query);

    @Query("select u from User u where u.name = :name")
    List<User> findByName1(@Param("name") String name);

    @Query(value = "select * from accounts where u.username = ?1", nativeQuery = true)
    List<User> findByName2(String name);

    List<User> findByNameAndUsername(String name, String username);
}
