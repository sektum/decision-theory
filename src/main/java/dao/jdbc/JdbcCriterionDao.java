package dao.jdbc;

import dao.CriterionDao;
import dao.jdbc.mappers.CriterionMapper;
import dao.jdbc.mappers.RowMapper;
import entities.Criterion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCriterionDao implements CriterionDao {
    private ConnectionHolder connectionHolder = new ConnectionHolder();
    private RowMapper<Criterion> criterionRowMapper = new CriterionMapper();

    @Override
    public Iterable<Criterion> findAll() {
        String query = "select * from criterion";
        try (
                Connection conn = connectionHolder.getConnection();
                Statement stmt = conn.createStatement()
        )
        {
            List<Criterion> criteria = new ArrayList<>();
            ResultSet rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                criteria.add(criterionRowMapper.map(rs, i));
                i++;
            }
            return criteria;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Criterion findById(long critId) {
        String query = "select * from Criterion where IdCrit = ?";
        try (
                Connection conn = connectionHolder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
                ) {
            stmt.setLong(1, critId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return criterionRowMapper.map(rs, 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
