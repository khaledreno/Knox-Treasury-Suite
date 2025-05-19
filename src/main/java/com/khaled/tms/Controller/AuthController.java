package com.khaled.tms.Controller;

import com.khaled.tms.Entity.UserEntity;
import com.khaled.tms.Services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UsersServices usersServices;

    //signup

    @PostMapping("/user")
    public ResponseEntity<UserEntity> SignUp(@RequestBody UserEntity userEntity) {
        usersServices.addNewUser(userEntity);
        return ResponseEntity.ok(userEntity);
}


@DeleteMapping("/user")
    public ResponseEntity<String> DeleteUser(@RequestBody String userName) {
        usersServices.deleteUser(userName);
    return ResponseEntity.ok("User '" + userName + "' deleted successfully.");
}

@GetMapping("/users")
    public List<UserEntity> getUser() {
        return usersServices.getAllUsers();
}
}
