package dao;

import entities.Vector;

public interface VectorDao {
    Iterable<Vector> findAll();
}
