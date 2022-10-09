from apps.api.py_reading_oasis.database.database import Book
from apps.api.py_reading_oasis.exceptions.bad_request_error import BadRequestError
from apps.api.py_reading_oasis.exceptions.resource_not_found_error import ResourceNotFoundError
from apps.api.py_reading_oasis.models.direction import Direction
from apps.api.py_reading_oasis.repository import books_repository


def get_book(book_id):
    return get_book_by_id(book_id).serialize()


def get_books(pagination):
    if not _validate_book_sort(pagination.order, pagination.sort_field):
        raise BadRequestError("'{}' is not a valid book field.".format(pagination.sort_field))
    order = Book.created_at.desc()
    if pagination.order == Direction.ascending:
        order = Book.created_at.asc()
    books = books_repository.get_books()
    return [book.serialize() for book in books]


def create_book(request):
    book = Book(author=request.get('author'), title=request.get('title'))
    return books_repository.create_book(book).serialize()


def update_book(book_id, request):
    book = get_book_by_id(book_id)
    author = request.get('author')
    title = request.get('title')
    return books_repository.update_book(book, author, title).serialize()


def delete_book(book_id):
    book = get_book_by_id(book_id)
    books_repository.delete_book(book)


def get_book_by_id(book_id):
    book = books_repository.get_book(book_id)
    if book is None:
        raise ResourceNotFoundError("No book found with id '{}'".format(book_id))
    return book


def _validate_book_sort(direction, sort_field):
    if direction == Direction.ascending or direction == direction.descending and str(
            sort_field).strip() in Book.fields():
        return True
    return False
