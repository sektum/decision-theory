package dao.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T map(ResultSet rs, int rowNum) throws SQLException;
}
