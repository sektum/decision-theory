package dao.jdbc;

import dao.ResultDao;
import entities.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcResultDao implements ResultDao {
    private ConnectionHolder connectionHolder = new ConnectionHolder();

    @Override
    public List<Result> findAllByAltName(String altName) {
        return null;
    }

    @Override
    public List<Result> findAllByLpr(int idLpr) {
        return null;
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
