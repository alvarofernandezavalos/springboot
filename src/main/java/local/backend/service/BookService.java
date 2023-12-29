package local.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import local.backend.entity.BookEntity;
import local.backend.repository.BookRepository;

@Service
public class BookService implements IBookService {
  @Autowired
  private BookRepository  bookRepository;

  @Override
  public Optional<List<BookEntity>> findAll() {
    return Optional.of(bookRepository.findAll());
  }

  @Override
  public Optional<BookEntity> findById(int id) {
    return bookRepository.findById(id);
  }

  @Override
  public void deleteById(int id) {
    bookRepository.deleteById(id);
  }

  @Override
  public Optional<BookEntity> insertBook(BookEntity book) {
    return Optional.of(bookRepository.save(book));
  }

  @Override
  public Optional<BookEntity> updateBook(int id, BookEntity book) {
    book.setId(id);
    return Optional.of(bookRepository.save(book));
  }
}  