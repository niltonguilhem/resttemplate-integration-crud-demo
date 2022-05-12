package com.example.resttemplateintegrationcruddemo.service;

import com.example.resttemplateintegrationcruddemo.config.RestTemplateIntegration;
import com.example.resttemplateintegrationcruddemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TestKeySpaceService {

    @Autowired
    private RestTemplateIntegration restTemplate;

    public Book[] getBook(){
        Book[] book = restTemplate.getForObject("http://localhost:8080/api/v1/testKeySpace",Book[].class);
        return book;
    }

    public Book getBookById(UUID id){
        Book book = restTemplate.getForObject("http://localhost:8080/api/v1/testKeySpace"+id,Book.class);
        return book;
    }
}
