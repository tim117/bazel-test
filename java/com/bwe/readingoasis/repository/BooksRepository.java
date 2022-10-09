package com.bwe.readingoasis.repository;

import com.bwe.readingoasis.entity.Book;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public interface BooksRepository extends JpaRepository<Book, UUID> {
  @Override
  Book save(Book book);

  @Override
  Optional<Book> findById(UUID id);

  @Override
  void deleteById(UUID id);

  @Override
  Page<Book> findAll(Pageable pageable);
}
