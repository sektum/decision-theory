package dao.jdbc;

import dao.VectorDao;
import dao.jdbc.mappers.RowMapper;
import dao.jdbc.mappers.VectorRowMapper;
import entities.Vector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcVectorDao implements VectorDao {
    private ConnectionHolder connectionHolder = new ConnectionHolder();
    private RowMapper<Vector> vectorRowMapper = new VectorRowMapper();

    @Override
    public Iterable<Vector> findAll() {
        String query = "select * from Vector";
        try (Connection conn = connectionHolder.getConnection(); Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery(query);
            List<Vector> vectors = new ArrayList<>();
            while (rs.next())
            {
                vectors.add(vectorRowMapper.map(rs, 0));
            }
            return vectors;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
