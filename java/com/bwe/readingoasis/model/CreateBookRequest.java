package com.bwe.readingoasis.model;

public final class CreateBookRequest {
  private final String author;
  private final String title;

  public CreateBookRequest(String author, String title) {
    this.author = author;
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }
}
