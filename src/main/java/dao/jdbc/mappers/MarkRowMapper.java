package dao.jdbc.mappers;

import entities.Mark;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkRowMapper implements RowMapper<Mark>{
    @Override
    public Mark map(ResultSet rs, int rowNum) {
        try {
            long id = rs.getLong("IdMark");
            long critId = rs.getLong("IdCrit");
            String name = rs.getString("MName");
            int range = rs.getInt("MRange");
            int number = rs.getInt("NumMark");
            int normalized = rs.getInt("NormMark");

            return new Mark(id, critId, name, range, number, normalized);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
