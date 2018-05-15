package dao.jdbc;

import dao.MarkDao;
import dao.jdbc.mappers.MarkRowMapper;
import dao.jdbc.mappers.RowMapper;
import entities.Mark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcMarkDao implements MarkDao {
    private ConnectionHolder connectionHolder = new ConnectionHolder();
    private RowMapper<Mark> markRowMapper = new MarkRowMapper();

    @Override
    public Iterable<Mark> findByCritId(long critId) {
        String query = "select * from Mark where idCrit = ?";
        try(
                Connection conn = connectionHolder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setLong(1, critId);
            ResultSet rs = stmt.executeQuery();
            List<Mark> marks = new ArrayList<>();
            while (rs.next())
            {
                marks.add(markRowMapper.map(rs, 1));
            }

            return marks;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Mark findById(long markId) {
        String query = "select * from Mark where IdMark = ?";
        try(
                Connection conn = connectionHolder.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setLong(1, markId);
            ResultSet rs = stmt.executeQuery();

            return markRowMapper.map(rs, 1);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
