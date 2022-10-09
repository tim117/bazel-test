package models

type CreateBookRequest struct {
	Title  string `json:"title" binding:"required"`
	Author string `json:"author" binding:"required"`
}

type CreateBookResponse struct {
	Data Book `json:"data,omitempty"`
}
