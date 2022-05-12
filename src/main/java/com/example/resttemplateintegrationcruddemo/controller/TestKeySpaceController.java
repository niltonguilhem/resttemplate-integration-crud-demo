package com.example.resttemplateintegrationcruddemo.controller;

import com.example.resttemplateintegrationcruddemo.model.Book;
import com.example.resttemplateintegrationcruddemo.service.TestKeySpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/testKeySpace")
public class TestKeySpaceController {

    @Autowired
    private TestKeySpaceService service;

    @GetMapping()
    public Book[] get() {return service.getBook();}

    @GetMapping("/{id}")
    public Book get(@PathVariable("id") UUID id) {return service.getBookById(id);}


}
