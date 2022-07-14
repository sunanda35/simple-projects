package com.stackroute.capstone.controllers;

import com.stackroute.capstone.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class DataController {
  private final BookService bookService;

  @Autowired
  public DataController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping(value={"", "/recomended"})
  public ResponseEntity recomended(){
      var output = bookService.consumeApi("https://openlibrary.org/trending/daily.json?limit=10");
    return ResponseEntity.status(HttpStatus.OK).body(output);
  }

  @GetMapping(value={"", "/search"})
  public ResponseEntity search(@RequestParam(value = "q") String q){
    var output = bookService.consumeApi("https://openlibrary.org/search.json?q="+q+"&limit=10");
    return ResponseEntity.status(HttpStatus.OK).body(output);
  }
  @GetMapping(value={"", "/search-author"})
  public ResponseEntity authors(@RequestParam(value = "q") String q){
    var output = bookService.consumeApi("https://openlibrary.org/search.json?author="+q);
    return ResponseEntity.status(HttpStatus.OK).body(output);
  }
  @GetMapping(value = "/favorite")
  public ResponseEntity favorite(@RequestParam(value = "fav") String[] fav){
    return ResponseEntity.status(HttpStatus.OK).body(fav);
  }
}
