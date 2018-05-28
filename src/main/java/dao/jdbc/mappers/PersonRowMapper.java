package dao.jdbc.mappers;

import entities.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person map(ResultSet rs, int rowNum) {
        try {
            int id = rs.getInt("idLPR");
            String name = rs.getString("LName");
            int range = rs.getInt("LRange");

            return new Person(id, name, range);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
