from flask import request, jsonify

from apps.api.py_reading_oasis.controllers.controller import Controller
from apps.api.py_reading_oasis.models.pagination import Pagination
from apps.api.py_reading_oasis.services import books_service


class BooksController(Controller):
    """ Controller with api routes for working with books. """

    def __init__(self, app):
        """ Creates an instance of the BooksController with the Flask application.

        Args:
            app (Flask): The Flask application to create the api routes in
        """
        self.app = app

    def register(self):
        app = self.app

        @app.route("/api/books", methods=["POST"])
        def create_book():
            """ Creates a book in the py_reading_oasis database.

            The body should be provided in json format and should match the object { "author": "string", "title": "value" }.

            Retruns:
                Book: The book that was just created.
            """
            return jsonify(books_service.create_book(request.json)), 201

        @app.route("/api/books", methods=["GET"])
        def list_books():
            """ List a page of books from the database.

            Returns:
                list`Book`: A list of books that match the pagination request.
            """
            pagination = Pagination().from_query_params(request.args)
            return jsonify(books_service.get_books(pagination))

        @app.route("/api/books/<uuid:book_id>", methods=["GET"])
        def get_book_by_id(book_id):
            """ Gets a book by its id.

            Returns:
                Book: A book with the given id from the path.
            """
            return jsonify(books_service.get_book(book_id))

        @app.route("/api/books/<uuid:book_id>", methods=["PATCH", "PUT"])
        def update_book_by_id(book_id):
            """Updates a book by its id.

            Returns:
                Book: The updated book.
            """
            return jsonify(books_service.update_book(book_id, request.json))

        @app.route("/api/books/<uuid:book_id>", methods=["DELETE"])
        def delete_book_by_id(book_id):
            """Deletes a book by its id.

            Returns:
                None: None.
            """
            books_service.delete_book(book_id)
            return Controller.no_content_response()
