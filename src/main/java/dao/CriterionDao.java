package dao;

import entities.Criterion;

public interface CriterionDao {
    Iterable<Criterion> findAll();
}
