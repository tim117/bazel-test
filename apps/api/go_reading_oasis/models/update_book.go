package models

type UpdateBookRequest struct {
	Title  string `json:"title"`
	Author string `json:"author"`
}

type UpdateBookResponse struct {
	Data Book `json:"book"`
}
