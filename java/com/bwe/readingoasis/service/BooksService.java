package com.bwe.readingoasis.service;

import com.bwe.readingoasis.entity.Book;
import com.bwe.readingoasis.exception.ResourceNotFoundException;
import com.bwe.readingoasis.model.ApiListResponse;
import com.bwe.readingoasis.model.ApiResponse;
import com.bwe.readingoasis.model.CreateBookRequest;
import com.bwe.readingoasis.model.UpdateBookRequest;
import com.bwe.readingoasis.repository.BooksRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public final class BooksService {
  private final BooksRepository booksRepository;

  @Autowired
  public BooksService(BooksRepository booksRepository) {
    this.booksRepository = booksRepository;
  }

  public ApiResponse<Book> createBook(CreateBookRequest request) {
    Book book = booksRepository.save(Book.fromCreateBookRequest(request)
        .setId(newBookId())
        .build());
    return ApiResponse.builder(Book.newBook()).setData(book).build();
  }

  private UUID newBookId() {
    return UUID.randomUUID();
  }

  public ApiResponse<Book> getBookById(UUID id) {
    Optional<Book> book = booksRepository.findById(id);
    if (!book.isPresent()) {
      throw bookNotFoundExceptionWithId(id);
    }
    return ApiResponse.builder(Book.newBook()).setData(book.get()).build();
  }

  public ResourceNotFoundException bookNotFoundExceptionWithId(UUID id) {
    return ResourceNotFoundException.newResourceNotFoundException(
        String.format("Book with id %s not found.", id));
  }

  public ApiListResponse<Book> listBooks(Pageable pagination) {
    Page<Book> booksPage = booksRepository.findAll(pagination);
    List<Book> books = booksPage.get().collect(Collectors.toList());
    return ApiListResponse.builder(Book.newBook())
        .setData(books)
        .setPage(pagination.getPageNumber())
        .setSize(pagination.getPageSize())
        .setTotal(books.size())
        .build();
  }

  public ApiResponse<Book> updateBook(UUID id, UpdateBookRequest request) {
    Optional<Book> book = booksRepository.findById(id);
    if (!book.isPresent()) {
      throw bookNotFoundExceptionWithId(id);
    }
    Book updatedBook = book.get().updateFromUpdateBookRequest(request);
    booksRepository.save(updatedBook);
    return ApiResponse.builder(Book.newBook()).setData(updatedBook).build();
  }

  public void deleteBook(UUID id) {
    Optional<Book> book = booksRepository.findById(id);
    if (!book.isPresent()) {
      throw bookNotFoundExceptionWithId(id);
    }
    booksRepository.delete(book.get());
  }
}
