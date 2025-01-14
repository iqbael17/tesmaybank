package com.testujian.testujian.service;

import com.testujian.testujian.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserService {

    private static final String url = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;


    public  UserDTO createUser(Integer id, String title) {
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setTitle(title);
        return user;
    }

    public Page<UserDTO> getAll(Pageable pageable) {
        ResponseEntity<UserDTO[]> response = restTemplate.getForEntity(url, UserDTO[].class);

        List<UserDTO> posts = Arrays.asList(response.getBody());
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), posts.size());
        return new PageImpl<>(posts.subList(start, end), pageable, posts.size());
    }

}
