package dao.jdbc;

import dao.AlternativeDao;
import dao.jdbc.mappers.AlternativeRowMapper;
import dao.jdbc.mappers.RowMapper;
import entities.Alternative;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcAlternativeDao implements AlternativeDao {
    private ConnectionHolder connectionHolder = new ConnectionHolder();
    private RowMapper<Alternative> alternativeRowMapper = new AlternativeRowMapper();

    @Override
    public Iterable<Alternative> findAll() {
        String query = "select * from Alternative";
        try (
                Connection conn = connectionHolder.getConnection();
                Statement stmt = conn.createStatement()
        ) {
            ResultSet rs = stmt.executeQuery(query);
            List<Alternative> alternativeCollection = new ArrayList<>();
            int i = 0;
            while (rs.next())
            {
                alternativeCollection.add(alternativeRowMapper.map(rs, i));
                i++;
            }
            return alternativeCollection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Alternative findById(long id) {
        String query = "select * from Alternative where idAlt = ?";
        try (
                Connection conn = connectionHolder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return alternativeRowMapper.map(rs, 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long findByName(String name) {
        String query = "select * from Alternative where AName = ?";
        try (
                Connection conn = connectionHolder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return alternativeRowMapper.map(rs, 1).getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
