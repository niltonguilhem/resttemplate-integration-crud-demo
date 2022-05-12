package com.example.resttemplateintegrationcruddemo.service;

import com.example.resttemplateintegrationcruddemo.config.RestTemplateIntegration;
import com.example.resttemplateintegrationcruddemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
        Book book = restTemplate.getForObject("http://localhost:8080/api/v1/testKeySpace/"+id,Book.class);
        return book;
    }

    public Book insert(Book book){
        ResponseEntity<Book> bookEntity =
                restTemplate.postForEntity("http://localhost:8080/api/v1/testKeySpace",book,Book.class);
        return  bookEntity.getBody();
    }

    public Book update(Book book, UUID id) {
        HttpEntity requestEntity = new HttpEntity<>(book);
        ResponseEntity<Book> bookEntity =
                restTemplate.exchange("http://localhost:8080/api/v1/testKeySpace/"+id, HttpMethod.PUT,requestEntity,
                        Book.class);
        return bookEntity.getBody();

    }

    public void delete(UUID id) {
        ResponseEntity<Book> bookEntity = restTemplate.exchange("http://localhost:8080/api/v1/testKeySpace/"+id
            ,HttpMethod.DELETE, null, Book.class);
    }
}
