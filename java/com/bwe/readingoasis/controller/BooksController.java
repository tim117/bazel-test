package com.bwe.readingoasis.controller;

import com.bwe.readingoasis.entity.Book;
import com.bwe.readingoasis.model.ApiListResponse;
import com.bwe.readingoasis.model.ApiResponse;
import com.bwe.readingoasis.model.CreateBookRequest;
import com.bwe.readingoasis.model.UpdateBookRequest;
import com.bwe.readingoasis.service.BooksService;
import java.net.URI;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public final class BooksController {
  private final BooksService booksService;

  @Autowired
  public BooksController(BooksService booksService) {
    this.booksService = booksService;
  }

  @GetMapping
  public ResponseEntity<ApiListResponse<Book>> listBooks(Pageable pagination) {
    ApiListResponse<Book> booksResponse = booksService.listBooks(pagination);
    return ResponseEntity.ok(booksResponse);
  }

  @PostMapping
  public ResponseEntity<ApiResponse<Book>> createBook(@RequestBody CreateBookRequest request) {
    ApiResponse<Book> bookResponse = booksService.createBook(request);
    return ResponseEntity.created(URI.create("/books/" + bookResponse.getData().getId()))
        .body(bookResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<Book>> getBook(@PathVariable UUID id) {
    ApiResponse<Book> bookResponse = booksService.getBookById(id);
    return ResponseEntity.ok(bookResponse);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ApiResponse<Book>> updateBook(@PathVariable UUID id,
      @RequestBody UpdateBookRequest request) {
    ApiResponse<Book> bookResponse = booksService.updateBook(id, request);
    return ResponseEntity.ok(bookResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse<Book>> deleteBook(@PathVariable UUID id) {
    booksService.deleteBook(id);
    return ResponseEntity.noContent().build();
  }
}
