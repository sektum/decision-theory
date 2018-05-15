package dao.jdbc;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHolder {
    private static final DataSource DS;
    static {
        Properties prop = new Properties();
        InputStream is;
        try {
            is = ConnectionHolder.class.getResourceAsStream("/application.properties");
            prop.load(is);
        } catch (IOException e) {
            throw new ExceptionInInitializerError();
        }

        DS = new JdbcDataSource();
        ((JdbcDataSource) DS).setURL(prop.getProperty("datasource.url"));
        ((JdbcDataSource) DS).setUser(prop.getProperty("datasource.username"));
        ((JdbcDataSource) DS).setPassword(prop.getProperty("datasource.password"));
    }

    public Connection getConnection()
    {
        try {
            return DS.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
