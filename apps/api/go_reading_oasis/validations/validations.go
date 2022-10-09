package validations

import (
	"strconv"

	"github.com/bwe/bwe/apps/api/go_reading_oasis/models"
	"github.com/gin-gonic/gin"
)

func IsBookPresent(book *models.Book) bool {
	return book != nil || !book.IsEmpty()
}

func IsDigit(char rune) bool {
	if char < '0' || char > '9' {
		return false
	}
	return true
}

func IsNumeric(str string) bool {
	if len(str) < 1 {
		return false
	}
	for _, c := range str {
		if !IsDigit(c) {
			return false
		}
	}
	return true
}

func VerifyBookID(context *gin.Context) (int, models.Error) {
	idParam := context.Param("id")
	if !IsNumeric(idParam) {
		return -1, models.ApiError{Type: models.BadRequestError, Message: "ID must be numeric."}
	}
	id, _ := strconv.Atoi(idParam)
	return id, nil
}
