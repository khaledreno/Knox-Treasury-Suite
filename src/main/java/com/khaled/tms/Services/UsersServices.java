package com.khaled.tms.Services;

import com.khaled.tms.Entity.UserEntity;
import com.khaled.tms.Repo.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServices {

    private static final Logger log = LoggerFactory.getLogger(UsersServices.class);
    @Autowired
    private UserRepo userRepo;

    public UsersServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    public boolean isUserExist(String username) {
       return userRepo.existsByUsername(username);
    }

//    public UserEntity getUserByUsername(String username) {
//        return userRepo.findByUsername(username).
//    }

    public UserEntity getUserByUsername(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User with username " + username + " not found"));
    }

    public UserEntity addNewUser(UserEntity user) {
   if (userRepo.existsByUsername(user.getUsername())) {
       throw new IllegalArgumentException("Username already exists");
   }
    UserEntity uservar = new UserEntity().builder()
            .username(user.getUsername())
            .email(user.getEmail())
            .role(user.getRole())
            .phone(user.getPhone())
            .password(user.getPassword())
            .build();
       log.info("New user created with id {}", user.getId());
        return userRepo.save(uservar);


    }

    }

