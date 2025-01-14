package com.testujian.testujian.service;

import com.testujian.testujian.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    private static final String url = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;


    public List<UserDTO> getAll() {
        ResponseEntity<UserDTO[]> data = restTemplate.getForEntity(url, UserDTO[].class);
      log.info("datas :{}",data);
        return Arrays.stream(data.getBody()).map(i -> new UserDTO(i.getId(), i.getTitle())).collect(Collectors.toList());
//return null;
    }

}
