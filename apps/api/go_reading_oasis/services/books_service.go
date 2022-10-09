package services

import (
	"fmt"

	"github.com/bwe/bwe/apps/api/go_reading_oasis/data"
	"github.com/bwe/bwe/apps/api/go_reading_oasis/models"
)

// Gets a list of books from the database.
func ListBooks(pagination models.Pagination) (*models.ListBooksResponse, models.Error) {
	books, err := data.GetBooks(&pagination)
	if err != nil {
		return nil, err.Error()
	}
	count := len(books)
	return &models.ListBooksResponse{
		Data:  books,
		Page:  &pagination.Page,
		Limit: &pagination.Limit,
		Count: &count,
	}, nil
}

// Creates a book.
func CreateBook(request models.CreateBookRequest) (*models.CreateBookResponse, models.Error) {
	book := models.Book{Author: request.Author, Title: request.Title}
	if _, err := data.CreateBook(&book); err != nil {
		return nil, err.Error()
	}
	return &models.CreateBookResponse{Data: book}, nil
}

// Gets a book from the database by its ID.
//
// Returns the GetBookResponse with the book as the "Data", whether the book was not found, and any
// errors that occurred while performing the operation.
func GetBook(id int) (*models.GetBookResponse, models.Error) {
	book, err := data.GetBook(id)
	if err != nil {
		return nil, getBookNotFoundError(id)
	}
	return &models.GetBookResponse{Data: *book}, nil
}

// Updates the book with the given ID in the database.
//
// Returns the update book response with the book value as data, whether the book was not found
// (true if it was not found) in the database, and any errors that occured while performing the
// operation.
func UpdateBook(id int, request models.UpdateBookRequest) (*models.UpdateBookResponse, bool, models.Error) {
	book, err := data.GetBook(id)
	if err != nil {
		return nil, true, getBookNotFoundError(id)
	}
	book.Author = request.Author
	book.Title = request.Title
	if err := data.UpdateBook(book); err != nil {
		return nil, false, err.Error()
	}
	return &models.UpdateBookResponse{Data: *book}, false, nil
}

// Deletes the book with the given id in the database.
//
// Returns whether the book was not found and any errors that occured during the operation.
func DeleteBook(id int) models.Error {
	book, err := data.GetBook(id)
	if err != nil {
		return getBookNotFoundError(id)
	}
	if err := data.DeleteBook(book); err != nil {
		return err.Error()
	}
	return nil
}

func getBookNotFoundError(id int) models.Error {
	return models.ApiError{Type: models.NotFoundError,
		Message: fmt.Sprintf("Book with ID [%v] was not found.", id)}
}
