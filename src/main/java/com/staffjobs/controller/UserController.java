package com.staffjobs.controller;

import com.staffjobs.entity.User;
import com.staffjobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Transactional(readOnly = true)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String view() {
        List<User> users = userRepository.findAll();
        return "Hello World!";
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> list() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public String showId(@PathVariable("id") int id){
//        if (result.hasErrors()){
//            return "hasErrors";
//        }
        return id+"";
    }
}
