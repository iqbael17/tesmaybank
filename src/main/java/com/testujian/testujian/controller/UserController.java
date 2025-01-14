package com.testujian.testujian.controller;


import com.testujian.testujian.model.UserDTO;
import com.testujian.testujian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserDTO> getAll(){
      return   userService.getAll();
    }

}
