package models

type ListBooksResponse struct {
	Data  []Book `json:"data"`
	Page  *int   `json:"page,omitempty"`
	Limit *int   `json:"limit,omitempty"`
	Count *int   `json:"count,omitempty"`
}
