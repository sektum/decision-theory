package dao.jdbc.mappers;

import entities.Vector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VectorRowMapper implements RowMapper<Vector> {
    @Override
    public Vector map(ResultSet rs, int rowNum) {
        try {
            long id = rs.getLong("idVect");
            long altId = rs.getLong("idAlt");
            long markId = rs.getLong("idMark");

            return new Vector(id, altId, markId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
