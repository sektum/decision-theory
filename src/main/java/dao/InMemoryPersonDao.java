package dao;

import entities.Person;

import java.util.Arrays;
import java.util.List;

public class InMemoryPersonDao implements PersonDao {
    private static final List<Person> PERSONS;
    static {
        PERSONS = Arrays.asList(new Person(1, "Valeriia Grankina", 100));
    }
    public Iterable<Person> findAll() {
        return PERSONS;
    }
}
