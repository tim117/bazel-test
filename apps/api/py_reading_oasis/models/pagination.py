from apps.api.py_reading_oasis.models.direction import Direction


class Pagination:

    def __init__(self, size=20, page=0, sort='-created_at'):
        self.size = size
        self.page = page
        self.sort = sort

    def from_query_params(self, params):
        """Creates a pagination request from query params"""
        size = params.get('size')
        page = params.get('page')
        sort = params.get('sort')
        if size is not None and size != '':
            self.size = size
        if page is not None and page != '':
            self.page = page
        if sort is not None and sort != '':
            self.sort = sort
        return self

    @property
    def order(self):
        """The sort direction for the page."""
        direction = self.sort[0]
        if direction == '-':
            return Direction.descending
        return Direction.ascending

    @property
    def sort_field(self):
        """The field to sort the page by."""
        direction = self.sort[0]
        if direction == '-' or direction == '+' or direction == ' ':
            return self.sort[1:]
        return self.sort
