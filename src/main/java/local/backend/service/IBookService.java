package local.backend.service;

import java.util.List;
import java.util.Optional;

import local.backend.entity.BookEntity;

interface IBookService {
  
  Optional<List<BookEntity>>    findAll();
  Optional<BookEntity>          findById(int id);
  void                          deleteById(int id);
  Optional<BookEntity>          insertBook(BookEntity book);
  Optional<BookEntity>          updateBook(int id, BookEntity book);
}

    