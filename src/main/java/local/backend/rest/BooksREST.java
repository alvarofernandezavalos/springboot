package local.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
