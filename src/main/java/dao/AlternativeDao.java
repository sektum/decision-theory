package dao;

import entities.Alternative;

public interface AlternativeDao {
    Iterable<Alternative> findAll();
}
