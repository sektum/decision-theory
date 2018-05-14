package dao;

import entities.Mark;

public interface MarkDao {
    Iterable<Mark> findByCritId(long critId);
    Mark findById(long markId);
}
