package dao;

import entities.Person;

public interface PersonDao {
    Iterable<Person> findAll();

}
