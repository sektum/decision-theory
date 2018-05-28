package dao.jdbc.mappers;

import entities.Result;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultMapper implements RowMapper<Result> {
    @Override
    public Result map(ResultSet rs, int rowNum) {
        try {
            return Result.builder()
                    .idLpr(rs.getInt("idLpr"))
                    .idAlt(rs.getLong("idAlt"))
                    .aWeight(rs.getLong("aweight"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
