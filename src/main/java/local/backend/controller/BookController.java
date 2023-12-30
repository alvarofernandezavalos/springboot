package local.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.backend.entity.BookEntity;
import local.backend.service.BookService;

@RestController
@RequestMapping("book")
public class BookController {

  @Autowired
  BookService bookService;
  
  @GetMapping()
  public ResponseEntity<?> getBooks() {
    if (bookService.findAll().get().size()>1) return ResponseEntity.ok(bookService.findAll().get());
    return ResponseEntity.ok(bookService.findAll().get().getFirst());
  }

  @GetMapping(value="{bookId}")
  public ResponseEntity<BookEntity> getBookById(@PathVariable("bookId") Integer id) {  
    if (bookService.findById(id).isPresent()) return ResponseEntity.ok(bookService.findById(id).get());
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping(value="{bookId}")
  public ResponseEntity<?> delete(@PathVariable("bookId") Integer id) {
    if(bookService.findById(id).isPresent()) {
      bookService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<?> insertBook(@RequestBody BookEntity book) {
    if(bookService.insertBook(book).isPresent()) return new ResponseEntity<>(HttpStatus.OK); 
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PutMapping(path="{bookId}")
  public ResponseEntity<?> updateBook(@PathVariable("bookId") Integer id, @RequestBody BookEntity book) {
    if(bookService.updateBook(id, book).isPresent()) return new ResponseEntity<BookEntity>(bookService.findById(id).get(), HttpStatus.OK); 
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
