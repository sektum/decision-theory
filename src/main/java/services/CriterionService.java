package services;

import dao.CriterionDao;
import dao.MarkDao;
import dao.jdbc.JdbcCriterionDao;
import dao.jdbc.JdbcMarkDao;
import entities.Criterion;

public class CriterionService {
    private CriterionDao criterionDao = new JdbcCriterionDao();
    private MarkDao markDao = new JdbcMarkDao();

    public Iterable<Criterion> findAll()
    {
        return criterionDao.findAll();
    }

    public Iterable<Criterion> findWithMarks()
    {
        Iterable<Criterion> criteria = criterionDao.findAll();
        criteria.forEach(criterion ->
            criterion.setMarks(markDao.findByCritId(criterion.getId()))
        );

        return criteria;
    }
}
