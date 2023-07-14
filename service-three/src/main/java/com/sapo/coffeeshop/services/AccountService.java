package com.sapo.coffeeshop.services;

import com.sapo.coffeeshop.common.Provider;
import com.sapo.coffeeshop.models.entity.User;
import com.sapo.coffeeshop.models.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final UserRepository userRepository;

    public AccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void processOAuthPostLogin(String username) {
        User existUser = userRepository.findUserByUsername(username);

        if (existUser == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setProvider(Provider.GOOGLE);

            userRepository.save(newUser);

            System.out.println("Created new user: " + username);
        }

    }
}
