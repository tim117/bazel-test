package com.bwe.readingoasis.entity;

import com.bwe.readingoasis.model.CreateBookRequest;
import com.bwe.readingoasis.model.UpdateBookRequest;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Book entity.
 */
@Entity
@EnableJpaAuditing
@Table(name = "books")
public final class Book {
  /**
   * Book id.
   */
  @Id
  private UUID id = UUID.randomUUID();
  /**
   * Book title.
   */
  private String title;
  /**
   * Book author.
   */
  private String author;
  /**
   * The date the book was last modified.
   */
  @UpdateTimestamp
  private Date updatedAt;
  /**
   * The date the book was created.
   */
  @CreationTimestamp
  private Date createdAt;

  /**
   * Default constructor.
   */
  public Book() {
  }

  /**
   * Creates a {@link Book} with all parameters.
   *
   * @param id        book id
   * @param title     book title
   * @param author    book author
   * @param createdAt book creation date
   * @param updatedAt book last modification date
   */
  public Book(UUID id, String title, String author, Date createdAt, Date updatedAt) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public static Builder fromCreateBookRequest(CreateBookRequest request) {
    return Book.builder().setTitle(request.getTitle()).setAuthor(request.getAuthor());
  }

  /**
   * Creates a new {@link Builder} for {@link Book}.
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Creates a new book with the default constructor.
   */
  public static Book newBook() {
    return new Book();
  }

  public Book updateFromUpdateBookRequest(UpdateBookRequest request) {
    if (request.getTitle() != null && !request.getTitle().isEmpty()) {
      this.title = request.getTitle();
    }
    if (request.getAuthor() != null && !request.getAuthor().isEmpty()) {
      this.author = request.getAuthor();
    }
    return this;
  }

  /**
   * @return the id
   */
  public UUID getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * @param author the author to set
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * @return the {@link Date} createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * @param createdAt the createdAt {@link Date} to set
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return the {@link Date} updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * @param updatedAt the updatedAt {@link Date} to set
   */
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * @return a {@link String} representation of the {@link Book}
   */
  @Override
  public String toString() {
    return "Book[id=" + id + ", title=" + title + ", author=" + author + ", createdAt="
        + createdAt + ", updatedAt=" + updatedAt + "]";
  }

  /**
   * Builder for {@link Book}.
   */
  public static class Builder {
    private UUID id;
    private String title;
    private String author;
    private Date createdAt;
    private Date updatedAt;

    /**
     * Sets the ID to use when creating the book
     */
    public Builder setId(UUID id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the title to use when creating the book
     */
    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    /**
     * Sets the author to use when creating the book
     */
    public Builder setAuthor(String author) {
      this.author = author;
      return this;
    }

    /**
     * Sets the createdAt date to use when creating the book
     */
    public Builder setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    /**
     * Sets the updatedAt date to use when creating the book.
     */
    public Builder setUpdatedAt(Date updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    /**
     * Builds the book using the set parameters.
     */
    public Book build() {
      return new Book(id, title, author, createdAt, updatedAt);
    }
  }
}
