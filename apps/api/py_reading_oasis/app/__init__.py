import json

from flask import Flask, render_template

from apps.api.py_reading_oasis.controllers.books_controller import BooksController
from apps.api.py_reading_oasis.database.database import db
from apps.api.py_reading_oasis.exceptions.bad_request_error import BadRequestError
from apps.api.py_reading_oasis.exceptions.resource_not_found_error import ResourceNotFoundError

application = Flask(__name__)
application.config.from_object('config.Config')
with application.app_context():
    db.init_app(application)
    db.create_all()


@application.route('/api/health-check')
def health_check():
    """Endpoint to check whether the app is running without error.

    Returns:
        str: A message indicating that the app is running.
    """
    return '✅ This application is healthy.'


@application.route('/')
def home():
    """Endpoint that displays the home.html page.

    Returns:
        str: The string of html for the home.html template.
    """
    return render_template("home.html")


@application.errorhandler(Exception)
def handle_server_error(e):
    """Handles unspecified errors.

    Returns:
        json: JSON response with the error message.
    """
    return json.dumps({'code': 'INTERNAL_SERVER_ERROR', 'status': 500,
                       'message': 'An error occurred on the server. Please try again later. {}'.format(e)}), 500


@application.errorhandler(BadRequestError)
def handle_bad_request(e):
    """Handles bad request errors

    Returns:
        json: A JSON representation of the error.
    """
    return e.json(), 400


@application.errorhandler(404)
@application.errorhandler(ResourceNotFoundError)
def handle_bad_request(e):
    """Handles 404 errors.

    Returns:
        json: A JSON response with the error message.
    """
    return json.dumps({'code': 'RESOURCE_NOT_FOUND', 'status': 404,
                       'message': str(e)}), 404


# Register controllers.
BooksController(application).register()
