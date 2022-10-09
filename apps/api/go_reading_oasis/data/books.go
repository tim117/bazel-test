package data

import "github.com/bwe/bwe/apps/api/go_reading_oasis/models"

func GetBook(id int) (*models.Book, models.Error) {
	var book models.Book
	if err := DB.Where("id = ?", id).First(&book).Error; err != nil {
		return nil, models.ApiError{Type: models.DatabaseError, Message: err.Error()}
	}
	return &book, nil
}

func GetBooks(pagination *models.Pagination) ([]models.Book, models.Error) {
	var books []models.Book
	if (pagination == nil || pagination == &models.Pagination{}) {
		DB.Find(&books)
		return books, nil
	}
	if !pagination.HasSort() || pagination.Limit < 1 || pagination.Page < 1 {
		return nil, models.ApiError{Type: models.DatabaseError,
			Message: "Pagination must contain a sort, a limit, and a page."}
	}
	if err := verifySort(*pagination); err != nil {
		return nil, err
	}
	sort, _ := pagination.FullSort()
	println(sort)
	if err := DB.Limit(pagination.Limit).
		Offset(pagination.Offset()).
		Order(sort).
		Find(&books).Error; err != nil {
		return nil, models.ApiError{Type: models.DatabaseError, Message: err.Error()}
	}
	return books, nil
}

func CreateBook(book *models.Book) (models.Book, models.Error) {
	if err := DB.Create(&book).Error; err != nil {
		return models.Book{}, models.ApiError{Type: models.DatabaseError, Message: err.Error()}
	}

	return *book, nil
}

func UpdateBook(book *models.Book) models.Error {
	if err := DB.Updates(&book).Error; err != nil {
		return models.ApiError{Type: models.DatabaseError, Message: err.Error()}
	}
	return nil
}

func DeleteBook(book *models.Book) models.Error {
	if err := DB.Delete(book).Error; err != nil {
		return models.ApiError{Type: models.DatabaseError, Message: err.Error()}
	}
	return nil
}

func verifySort(pagination models.Pagination) models.Error {
	sort, err := pagination.SortField()
	if err != nil {
		return err
	}
	if _, err := pagination.FullSort(); err != nil {
		return err
	}
	if !models.IsBookField(sort) {
		return models.ApiError{Type: models.PaginationError,
			Message: "The sort value must be a valid book field."}
	}
	return nil
}
