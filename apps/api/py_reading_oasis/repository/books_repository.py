from apps.api.py_reading_oasis.database.database import Book

from apps.api.py_reading_oasis.database.database import db


def get_book(book_id):
    return Book.query.get(book_id)


def get_books(order, page, size):
    return Book.query.order_by(order).paginate(page, size, error_out=False, max_per_page=1000).items


def create_book(book):
    db.session.add(book)
    db.session.commit()
    return book


def update_book(book, author, title):
    if author is not None:
        book.author = author
    if title is not None:
        book.title = title
    db.session.commit()
    return book


def delete_book(book):
    db.session.delete(book)
    db.session.commit()
