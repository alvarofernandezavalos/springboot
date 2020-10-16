package local.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import local.backend.entity.Books;

public interface BooksDAO extends JpaRepository<Books, Integer> {  }