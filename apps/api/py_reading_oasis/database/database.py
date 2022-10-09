import uuid
from abc import abstractmethod

from flask_sqlalchemy import SQLAlchemy

from libs.sqlalchemy_guidpy.guid import GUID

db = SQLAlchemy()
"""The database for the application."""


class DBModelBase(db.Model):
    """Base class for database models.

    This class should be used as the base class for any database object and includes the id, created_at, and updated_at
    fields.

    Attributes:
        id (uuid): The uuid used to identify the object in the database.
        created_at (datetime): The date that the object was created in the database.
        updated_at (datetime): The date that the object was created in the database.
    """
    __abstract__ = True

    id = db.Column(GUID(), primary_key=True, default=lambda: str(uuid.uuid4()))
    created_at = db.Column(db.DateTime, default=db.func.current_timestamp())
    updated_at = db.Column(db.DateTime,
                           default=db.func.current_timestamp(),
                           onupdate=db.func.current_timestamp())

    @abstractmethod
    def serialize(self):
        pass


class Book(DBModelBase):
    """A representation of a book in the reading oasis store.

    Attributes:
        author (str): The person who wrote the book.
        title (str): The name of the book.
    """

    __tablename__ = "books"

    title = db.Column(db.String(250), nullable=False)
    author = db.Column(db.String(250), nullable=False)

    def __init__(self, title, author):
        """Initializes a Book with the given author and title.

        Args:
            author (str): The person who wrote the book.
            title (str): The name of the book.
        """
        self.title = title
        self.author = author

    def __repr__(self):
        return f"Book{{id = {self.id}, author = {self.author}, title = {self.title}, created_at = {self.created_at}, " \
               f"updated_at = {self.updated_at}}}"

    @staticmethod
    def fields():
        """Gets all valid Book fields.

        Returns:
            A set of the string name of the fields on the Book object.
        """
        return {'id', 'author', 'title', 'created_at', 'updated_at'}

    def serialize(self):
        """Creates a dictionary representation of a Book.

        Returns:
            dict: A dictionary representation of the Book.
        """
        return {
            'id': str(self.id),
            'title': self.title,
            'author': self.author,
            'created_at': str(self.created_at),
            'updated_at': str(self.updated_at),
        }
