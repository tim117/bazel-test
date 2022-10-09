from abc import abstractmethod

from flask import make_response


class Controller:
    __abstract__ = True

    @abstractmethod
    def register(self):
        pass

    @staticmethod
    def no_content_response():
        response = make_response('', 204)
        response.mimetype = 'application/json'
        return response
