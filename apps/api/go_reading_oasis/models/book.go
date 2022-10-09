package models

import (
	"time"

	"github.com/google/uuid"
)

type Book struct {
	ID        uuid.UUID `json:"id,omitempty" gorm:"type:UUID,primary_key"`
	Title     string    `json:"title,omitempty"`
	Author    string    `json:"author,omitempty"`
	CreatedAt time.Time `json:"createdAt,omitempty"`
	UpdatedAt time.Time `json:"updatedAt,omitempty"`
}

func (b Book) IsEmpty() bool {
	if (b == Book{}) {
		return true
	}
	return false
}

type BookField string

const (
	Id        BookField = "id"
	Title     BookField = "title"
	Author    BookField = "author"
	CreatedAt BookField = "created_at"
	UpdatedAt BookField = "updated_at"
)

func IsBookField(field string) bool {
	bookField := BookField(field)
	if bookField == Id {
		return true
	}
	if bookField == Title {
		return true
	}
	if bookField == Author {
		return true
	}
	if bookField == CreatedAt {
		return true
	}
	if bookField == UpdatedAt {
		return true
	}
	return false
}
