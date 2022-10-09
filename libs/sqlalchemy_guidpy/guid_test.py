import unittest
import uuid

from sqlalchemy.dialects.postgresql import UUID, dialect as postgresql
from sqlalchemy.dialects.sqlite import dialect as sqlite
from sqlalchemy.types import CHAR

from guid import GUID


class TestGUID(unittest.TestCase):
    def test__load_dialect_impl__dialect_is_postgres__returns_postgres_uuid_type(self):
        # Arrange
        guid = GUID()
        dialect = postgresql()

        # Act
        res = guid.load_dialect_impl(dialect)

        # Assert
        self.assertTrue(_compare_column_types(dialect,
                                              res,
                                              dialect.type_descriptor(UUID())))

    def test__load_dialect_impl__dialect_not_postgres__returns_char_32_type(self):
        # Arrange.
        guid = GUID()
        dialect = sqlite()

        # Act.
        res = guid.load_dialect_impl(dialect)

        # Assert.
        self.assertTrue(_compare_column_types(dialect,
                                              res,
                                              dialect.type_descriptor(CHAR(32))))

    def test__process_bind_param__value_is_none__returns_none(self):
        # Arrange.
        guid = GUID()

        # Act.
        res = guid.process_bind_param(None, None)

        # Assert
        self.assertIsNone(res)

    def test__process_bind_param__dialect_is_postgres__returns_str_value(self):
        # Arrange.
        guid = GUID()

        # Act.
        res = guid.process_bind_param(12, postgresql())

        # Assert.
        self.assertEqual(res, '12')

    def test__process_bind_param__dialect_is_not_postgres_and_value_is_uuid__returns_uuid_int(self):
        # Arrange.
        guid = GUID()
        value = uuid.uuid4()

        # Act.
        res = guid.process_bind_param(value, sqlite())

        # Assert.
        self.assertEqual(res, "%.32x" % value.int)

    def test__process_result_value__value_is_none__returns_none(self):
        # Arrange.
        guid = GUID()

        # Act.
        res = guid.process_result_value(None, postgresql())

        # Assert.
        self.assertIsNone(res)

    def test__process_result_value__value_is_type_uuid__returns_value(self):
        # Arrange.
        guid = GUID()
        value = uuid.uuid4()

        # Act.
        res = guid.process_result_value(value, postgresql())

        # Assert.
        self.assertEqual(res, value)

    def test__process_result_value__value_is_not_type_uuid__returns_value(self):
        # Arrange.
        guid = GUID()
        value = 'a4dc787d-f577-4f0d-890b-e29bafdb988a'

        # Act.
        res = guid.process_result_value(value, postgresql())

        # Assert.
        self.assertEqual(str(res), value)


def _compare_column_types(dialect, column_type, compare_column_type):
    sql_column_type = dialect.type_compiler.process(column_type).lower()
    sql_compare_type = dialect.type_compiler.process(compare_column_type).lower()

    return sql_column_type == sql_compare_type


if __name__ == '__main__':
    unittest.main()
