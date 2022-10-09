package models

import (
	"fmt"
	"strings"
)

type Pagination struct {
	Limit int    `json:"limit"`
	Page  int    `json:"page"`
	Sort  string `json:"sort"`
}

func (p Pagination) Offset() int {
	return (p.Page - 1) * p.Limit
}

func (p Pagination) SortDirection() (string, Error) {
	if !p.HasSort() {
		return "", ApiError{Type: PaginationError,
			Message: "Sort cannot be empty."}
	}
	if p.Sort[0] == '+' || p.Sort[0] == ' ' {
		return "asc", nil
	}
	return "desc", nil
}

func (p Pagination) SortField() (string, Error) {
	p.Sort = strings.ReplaceAll(p.Sort, " ", "+")
	if !p.HasSort() {
		return "", ApiError{Type: PaginationError,
			Message: "Sort cannot be empty."}
	}
	if p.Sort[0] == '-' || p.Sort[0] == '+' {
		return p.Sort[1:], nil
	}
	return p.Sort, nil
}

func (p Pagination) HasSort() bool {
	if len(p.Sort) > 0 {
		return true
	}
	return false
}

func (p Pagination) FullSort() (string, Error) {
	field, err := p.SortField()
	if err != nil {
		return "", err.Error()
	}
	direction, err := p.SortDirection()
	if err != nil {
		return "", err.Error()
	}
	return fmt.Sprintf("%v %v", field, direction), nil
}
