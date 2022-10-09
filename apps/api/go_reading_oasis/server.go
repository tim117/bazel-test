package main

import (
	"embed"
	"html/template"
	"net/http"
	"os"

	"github.com/bwe/bwe/apps/api/go_reading_oasis/controllers"
	"github.com/bwe/bwe/apps/api/go_reading_oasis/data"
	"github.com/gin-gonic/gin"
)

//go:embed views/*
var views embed.FS

// Starts the GO Reading Oasis API.
func main() {
	setPort()
	data.ConnectToSqlite()
	router := gin.Default()
	templates := getTemplates()
	router.SetHTMLTemplate(templates)

	// Set the home route.
	router.GET("/", home)

	// Initialize routes.
	initRouters(router)

	router.Run()
}

// Implementation for the home route.
func home(context *gin.Context) {
	context.HTML(http.StatusOK, "home.html", gin.H{"title": "Welcome - Reading Oasis"})
}

// Initializes all of the routes for the API.
func initRouters(router *gin.Engine) {
	controllers.BooksRouter(router)
}

// Gets the templates from the embeded file system.
func getTemplates() *template.Template {
	return template.Must(template.New("").ParseFS(views, "views/*"))
}

// Sets the port by the environment variable.
func setPort() {
	// TODO: figure out how we want to handle environment variables in GO and create a library for it.
	args := os.Args[1:]
	os.Setenv("PORT", "3030")
	if len(args) > 0 {
		os.Setenv("PORT", args[0])
	}
}
