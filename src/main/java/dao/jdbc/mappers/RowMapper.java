package dao.jdbc.mappers;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T map(ResultSet rs, int rowNum);
}
