package dao.jdbc;

import entities.Alternative;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlternativeRowMapper implements RowMapper<Alternative> {
    @Override
    public Alternative map(ResultSet rs, int rowNum) {
        try {
            return new Alternative(rs.getLong("idAlt"), rs.getString("AName"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
