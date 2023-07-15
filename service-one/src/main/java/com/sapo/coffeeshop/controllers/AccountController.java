package com.sapo.coffeeshop.controllers;

import com.sapo.coffeeshop.models.repository.MySaveRepo;
import com.sapo.coffeeshop.models.repository.UserRepository;
import com.sapo.coffeeshop.models.repository.UserRepository1;
import com.sapo.coffeeshop.models.repository.UserRepository2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
public class AccountController {
    private final UserRepository userRepository;
    private final UserRepository1 userRepository1;
    private final UserRepository2 userRepository2;
    private final MySaveRepo mySaveRepo;
    private final ModelMapper mapper;
    public AccountController(UserRepository userRepository, UserRepository1 userRepository1, UserRepository2 userRepository2, MySaveRepo mySaveRepo, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.userRepository1 = userRepository1;
        this.userRepository2 = userRepository2;
        this.mySaveRepo = mySaveRepo;
        this.mapper = mapper;
    }


    @GetMapping
    public Object filter (){
        var users = userRepository1.countByStatus("active");
        var user = userRepository1.findById(1);
        var page = userRepository.findAll(PageRequest.of(1, 20));
        var usersNew = userRepository1.findByByStatus("active");
        var user2 = userRepository2.findById(1);
        var user3 = userRepository1.findByRoles_Id(1);


        Sort sort = Sort.by(Sort.Direction.ASC, "firstname");
        Pageable pageable = PageRequest.of(1, 2, sort);

        userRepository1.findByAddress("name", pageable);
        return user3;
    }

    @PostMapping
    public Object save () throws Exception {
        mySaveRepo.save(null);
        return null;
    }
}
