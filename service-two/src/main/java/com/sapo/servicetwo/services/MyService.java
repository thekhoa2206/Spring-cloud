package com.sapo.servicetwo.services;

import com.sapo.servicetwo.dao.MyDao;
import com.sapo.servicetwo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
    private final MyDao myDao;
    private final RabbitMqProvider rabbitMqProvider;

    public MyService(MyDao myDao, RabbitMqProvider rabbitMqProvider) {
        this.myDao = myDao;
        this.rabbitMqProvider = rabbitMqProvider;
    }

    public List<User> findAll(){
       var users=  myDao.findAll();
       var count = myDao.count();
       var users1 = myDao.findById(1);
       var users2 = myDao.findByUsername(2);
       User user = new User();
        user.setUsername("tenmoi");
        user.setName("Tên mới");
       //myDao.add(user);
        rabbitMqProvider.send(user);

       return users;
    }
}
