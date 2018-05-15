package dao.jdbc.mappers;

import entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CriterionMapper implements RowMapper<Criterion> {
    @Override
    public Criterion map(ResultSet rs, int rowNum) {
        try {
        int id = rs.getInt("IdCrit");
        String name = rs.getString("CName");
        int weight = rs.getInt("CWeight");
        String type = rs.getString("CType");
        String optimalType = rs.getString("OptimType");
        String unit = rs.getString("EdIzmer");
        String scale = rs.getString("ScaleType");
        Iterable<Mark> marks = new ArrayList<>();

        return new Criterion(id, name, weight, type, optimalType, unit, scale, marks);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
