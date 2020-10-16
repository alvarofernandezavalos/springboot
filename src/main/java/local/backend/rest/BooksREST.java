package local.backend.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import local.backend.daos.BooksDAO;
import local.backend.entity.Books;

@RestController
@RequestMapping("books")
public class BooksREST {

  @Autowired
  private BooksDAO  booksDAO;

  @GetMapping()
  public ResponseEntity<List<Books>> getBooks() {
    return ResponseEntity.ok(booksDAO.findAll());
  }

  @GetMapping(value="{bookId}")
  public ResponseEntity<Books> getBookById(@PathVariable("bookId") Integer id) {
    Optional<Books> aBook = booksDAO.findById(id);
    if (aBook.isPresent()) return ResponseEntity.ok(aBook.get());
    else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="{bookId}", method = RequestMethod.DELETE)
  public void deleteBook (@PathVariable("bookId") Integer id) {
    booksDAO.deleteById(id);
  }

  @PostMapping
  public void insertBook(@RequestBody Books book) {
    booksDAO.save(book);
  }
}
