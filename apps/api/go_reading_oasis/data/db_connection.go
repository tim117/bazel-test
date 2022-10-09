package data

import (
	"github.com/bwe/bwe/apps/api/go_reading_oasis/models"
	"gorm.io/driver/sqlite"
	"gorm.io/gorm"
)

var DB *gorm.DB

func ConnectToSqlite() {
	database, err := gorm.Open(sqlite.Open("books.db"))

	if err != nil {
		panic("Unable to connect to the database.")
	}

	database.AutoMigrate(&models.Book{})

	DB = database
}
