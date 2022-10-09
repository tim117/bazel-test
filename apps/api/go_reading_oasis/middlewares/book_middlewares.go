package middlewares

import (
	"net/http"

	"github.com/bwe/bwe/apps/api/go_reading_oasis/validations"
	"github.com/gin-gonic/gin"
)

// Verifies the request url's ID from the path and sets it for use in following Handlers.
func VerifyBookID(context *gin.Context) {
	id, err := validations.VerifyBookID(context)
	if err != nil {
		context.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	context.Set("id", id)
	context.Next()
}
