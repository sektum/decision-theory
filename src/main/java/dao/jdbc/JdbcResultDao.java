package dao.jdbc;

import dao.ResultDao;
import dao.jdbc.mappers.ResultMapper;
import dao.jdbc.mappers.RowMapper;
import entities.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcResultDao implements ResultDao {
    private ConnectionHolder connectionHolder = new ConnectionHolder();
    private RowMapper<Result> resultRowMapper = new ResultMapper();

    @Override
    public List<Result> findAllByAltName(String altName) {
        String query = "select * from Result where IDALT IN (Select IDALT from ALTERNATIVE where ANAME = ?) ORDER BY AWEIGHT DESC";
        try (
                Connection conn = connectionHolder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, altName);
            ResultSet rs = stmt.executeQuery();
            List<Result> results = new ArrayList<>();
            int i = 1;
            while (rs.next())
            {
                results.add(resultRowMapper.map(rs, i++));
            }
            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Result> findAllByLpr(int idLpr) {
        String query = "select * from Result where IDLPR = ? ORDER by AWEIGHT DESC";
        try (
                Connection conn = connectionHolder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, idLpr);
            ResultSet rs = stmt.executeQuery();
            List<Result> results = new ArrayList<>();
            int i = 1;
            while (rs.next()) {
                results.add(resultRowMapper.map(rs, i++));
            }
            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Result result) {
        String query = "merge into Result values (?, ?, ?)";
        try (
                Connection conn = connectionHolder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, result.getIdLpr());
            stmt.setLong(2, result.getIdAlt());
            stmt.setLong(3, result.getAWeight());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
