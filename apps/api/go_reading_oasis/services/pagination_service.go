package services

import (
	"strconv"

	"github.com/bwe/bwe/apps/api/go_reading_oasis/models"
	"github.com/gin-gonic/gin"
)

const DEFAULT_PAGE_LIMIT = 10
const DEFAULT_PAGE = 1
const DEFAULT_SORT = "-created_at"

func GeneratePaginationFromRequest(c *gin.Context) models.Pagination {
	// Initializing default
	limit := DEFAULT_PAGE_LIMIT
	page := DEFAULT_PAGE
	sort := DEFAULT_SORT
	query := c.Request.URL.Query()
	for key, value := range query {
		queryValue := value[len(value)-1]
		if key == "limit" {
			limit, _ = strconv.Atoi(queryValue)
		}
		if key == "page" {
			page, _ = strconv.Atoi(queryValue)
		}
		if key == "sort" {
			sort = queryValue
		}
	}
	if limit > 1000 {
		limit = 1000
	}
	return models.Pagination{
		Limit: limit,
		Page:  page,
		Sort:  sort,
	}
}
