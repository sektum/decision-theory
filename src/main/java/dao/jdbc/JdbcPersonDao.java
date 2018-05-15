package dao.jdbc;

import dao.PersonDao;
import dao.jdbc.mappers.PersonRowMapper;
import dao.jdbc.mappers.RowMapper;
import entities.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {
    private ConnectionHolder connectionHolder = new ConnectionHolder();
    private RowMapper<Person> personRowMapper = new PersonRowMapper();

    @Override
    public Iterable<Person> findAll() {
        String query = "Select * from LPR";
        try (Connection conn = connectionHolder.getConnection(); Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery(query);
            List<Person> persons = new ArrayList<>();
            int i = 0;
            while (rs.next())
            {
                i++;
                persons.add(personRowMapper.map(rs, i));
            }

            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
