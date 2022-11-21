package org.productdb.Config;

import java.sql.Connection;

public interface Database {

    public void closeConnection();

    public Connection getConnection();
}
