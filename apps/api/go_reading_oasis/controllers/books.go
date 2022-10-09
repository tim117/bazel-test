package controllers

import (
	"net/http"

	"github.com/bwe/bwe/apps/api/go_reading_oasis/middlewares"
	"github.com/bwe/bwe/apps/api/go_reading_oasis/models"
	"github.com/bwe/bwe/apps/api/go_reading_oasis/services"
	"github.com/gin-gonic/gin"
)

// Get a list of books.
func listBooks(context *gin.Context) {
	pagination := services.GeneratePaginationFromRequest(context)
	response, err := services.ListBooks(pagination)
	if err != nil {
		context.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	context.JSON(http.StatusOK, response)
}

// Create a new book.
func createBook(context *gin.Context) {
	// Validate the input.
	var request models.CreateBookRequest
	bindErr := context.ShouldBindJSON(&request)
	if bindErr != nil {
		error := &models.ApiError{Type: models.BadRequestError, Message: bindErr.Error()}
		context.JSON(http.StatusBadRequest, gin.H{"error": error})
		return
	}
	// Create book in database.
	response, err := services.CreateBook(request)
	if err != nil {
		context.JSON(http.StatusInternalServerError, err.Error())
		return
	}
	context.JSON(http.StatusCreated, response)
}

// Gets a book by its id.
func getBook(context *gin.Context) {
	// Get verified ID from context.
	id := context.GetInt("id")
	// Get book from the database.
	response, err := services.GetBook(id)
	if err != nil {
		context.JSON(http.StatusInternalServerError, err)
		return
	}
	context.JSON(http.StatusOK, response)
}

// Updates a book.
func updateBook(context *gin.Context) {
	// Get verified ID from context.
	id := context.GetInt("id")
	// Validate the input.
	var request models.UpdateBookRequest
	bindErr := context.ShouldBindJSON(&request)
	if bindErr != nil {
		error := &models.ApiError{Type: models.BadRequestError, Message: bindErr.Error()}
		context.JSON(http.StatusBadRequest, gin.H{"error": error})
		return
	}
	// Updates the book in the database.
	response, notFound, err := services.UpdateBook(id, request)
	if notFound {
		context.JSON(http.StatusNotFound, err)
		return
	}
	if err != nil {
		context.JSON(http.StatusInternalServerError, err)
		return
	}
	context.JSON(http.StatusOK, response)
}

// Deletes the book from the database.
func deleteBook(context *gin.Context) {
	// Get the given ID from the path.
	id := context.GetInt("id")
	// Delete the Book from the database
	err := services.DeleteBook(id)
	if err != nil {
		context.JSON(http.StatusInternalServerError, err)
		return
	}
	context.JSON(http.StatusNoContent, nil)
}

// Initializes all the book routes.
func BooksRouter(router *gin.Engine) {
	router.GET("/books", listBooks)
	router.POST("/books", createBook)
	router.GET("/books/:id", middlewares.VerifyBookID, getBook)
	router.PATCH("/books/:id", middlewares.VerifyBookID, updateBook)
	router.DELETE("/books/:id", middlewares.VerifyBookID, deleteBook)
}
