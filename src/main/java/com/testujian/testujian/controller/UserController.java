package com.testujian.testujian.controller;


import com.testujian.testujian.model.UserDTO;
import com.testujian.testujian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/paging")
    public Page<UserDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size) {
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Page Not FOund");
        }

        Pageable pageable = PageRequest.of(page, size);
        return userService.getAll(pageable);
    }

}
