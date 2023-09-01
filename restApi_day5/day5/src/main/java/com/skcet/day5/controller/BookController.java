package com.skcet.day5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.day5.model.Book;
import com.skcet.day5.service.BookService;

@RestController
@RequestMapping("api/v1/controller")
public class BookController {
      @Autowired
	private BookService bookService;
      
      @PostMapping("/add")
      public ResponseEntity<String> addValues(@RequestBody Book b)
      {
    	  boolean dataSaved=bookService.addValues(b);
    	  if(dataSaved)
    	  {
    		  return ResponseEntity.status(200).body("successfully added!");
    	  }
    	  else
    	  {
    		  return ResponseEntity.status(404).body("Not successfully added!");
    	  }
      }
      
      @GetMapping("/get")
      public ResponseEntity<List<Book>> getValues()
      {
    	  return ResponseEntity.status(200).body(bookService.getValues());
      }
      
      @PutMapping("/put/{id}")
      public ResponseEntity<String> updateValues(@PathVariable int id,@RequestBody Book b)
      {
    	  boolean data=bookService.updateValues(id, b);
    	  if(data)
    	  {
    		  return ResponseEntity.status(200).body("successfully updated!");
    	  }
    	  else
    	  {
    		  return ResponseEntity.status(404).body("Not successfully updated!");
    	  }
      }
      
      @DeleteMapping("/del/{id}")
      public ResponseEntity<String> deleteValues(@PathVariable int id)
      {
    	  boolean dataSaved=bookService.deleteValues(id);
    	  if(dataSaved)
    	  {
    		  return ResponseEntity.status(200).body("successfully deleted!");
    	  }
    	  else
    	  {
    		  return ResponseEntity.status(404).body("Not successfully deleted!");
    	  }
      }
}
