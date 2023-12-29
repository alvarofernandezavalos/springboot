package local.backend.controller;

import java.util.List;
import java.util.Optional;

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
import local.backend.repository.BookRepository;

@RestController
@RequestMapping("book")
public class BookController {

  @Autowired
  private BookRepository  booksDAO;

  @GetMapping()
  public ResponseEntity<List<BookEntity>> getBooks() {
    return ResponseEntity.ok(booksDAO.findAll());
  }

  @GetMapping(value="{bookId}")
  public ResponseEntity<BookEntity> getBookById(@PathVariable("bookId") Integer id) {
    Optional<BookEntity> aBook = booksDAO.findById(id);
    if (aBook.isPresent()) return ResponseEntity.ok(aBook.get());
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping(value="{bookId}")
  public ResponseEntity<BookEntity> delete(@PathVariable("bookId") Integer id) {
    Optional<BookEntity> aBook = booksDAO.findById(id);
    if(aBook.isPresent()) {
      booksDAO.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public void insertBook(@RequestBody BookEntity book) {
    booksDAO.save(book);
  }

  @PutMapping(path="{bookId}")
  public void updateBook(@PathVariable("bookId") Integer id, @RequestBody BookEntity book) {
    book.setId(id);
    booksDAO.save(book);
  }
}
