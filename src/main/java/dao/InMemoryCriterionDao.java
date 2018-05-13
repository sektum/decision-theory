package dao;

import entities.Criterion;
import entities.CriterionType;
import entities.OptimalType;
import entities.ScaleType;

import java.util.Arrays;
import java.util.List;

public class InMemoryCriterionDao implements CriterionDao {
    private static final List<Criterion> CRITERIA;
    static {
        CRITERIA = Arrays.asList(
                new Criterion(1, "Цена", 2, CriterionType.QUANTITATIVE, OptimalType.MIN, "Доллар", ScaleType.RATIO),
                new Criterion(2, "RAM", 2, CriterionType.QUANTITATIVE, OptimalType.MAX, "Gb", ScaleType.RATIO),
                new Criterion(3, "Тип диска", 3, CriterionType.QUALITATIVE, OptimalType.NOT_APPLICABLE, "", ScaleType.NOMINAL)
        );
    }
    public Iterable<Criterion> findAll() {
        return CRITERIA;
    }
}
