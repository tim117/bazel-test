import json


class ResourceNotFoundError(Exception):
    """Raised when a request is invalid."""

    def __init__(self, message='Invalid request.'):
        self.message = message

    def json(self):
        return json.dumps({'code': "BAD_REQUEST", 'status': 400, 'message': self.message})
