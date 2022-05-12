package com.example.resttemplateintegrationcruddemo.controller;

import com.example.resttemplateintegrationcruddemo.model.Book;
import com.example.resttemplateintegrationcruddemo.service.TestKeySpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Book> post(@RequestBody Book book){
        Book b = service.insert(book);
        return  new ResponseEntity(b, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> put(@PathVariable("id") UUID id, @RequestBody Book book){
        Book bookDto = new Book();
        bookDto.setName(book.getName());
        bookDto.setTitle(book.getTitle());
        bookDto.setId(id);

        Book b = service.update(book,id);

        return new ResponseEntity<>(b, HttpStatus.ALREADY_REPORTED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) { service.delete(id);}



}
