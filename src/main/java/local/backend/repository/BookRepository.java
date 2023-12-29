package local.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import local.backend.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {  }