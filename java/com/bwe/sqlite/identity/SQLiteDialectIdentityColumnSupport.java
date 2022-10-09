package com.bwe.sqlite.identity;

import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

public class SQLiteDialectIdentityColumnSupport extends IdentityColumnSupportImpl {
  @Override
  public boolean supportsIdentityColumns() {
    return true;
  }

  @Override
  public boolean supportsInsertSelectIdentity() {
    return true; // https://sqlite.org/lang_returning.html
  }

  @Override
  public boolean hasDataTypeInIdentityColumn() {
    return true;
  }

  @Override
  public String appendIdentitySelectToInsert(String insertString) {
    return insertString + " RETURNING rowid";
  }

  @Override
  public String getIdentitySelectString(String table, String column, int type) {
    return "select last_insert_rowid()";
  }

  @Override
  public String getIdentityColumnString(int type) {
    // return "integer primary key autoincrement";
    // FIXME "autoincrement"
    return "integer";
  }
}
