package dao.inmemory;

import dao.CriterionDao;
import entities.Criterion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryCriterionDao implements CriterionDao {
    private static final List<Criterion> CRITERIA;
    static {
        CRITERIA = Arrays.asList(
        );
    }
    public Iterable<Criterion> findAll() {
        return CRITERIA;
    }

    @Override
    public Criterion findById(long critId) {
        return CRITERIA.stream().filter(crit -> crit.getId() == critId).findFirst().orElse(null);
    }
}
