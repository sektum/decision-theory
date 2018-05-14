package services;

import dao.*;
import dto.Vector;
import entities.Alternative;
import entities.Criterion;
import entities.Mark;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class VectorService {
    private AlternativeDao alternativeDao = new InMemoryAlternativeDao();
    private CriterionDao criterionDao = new InMemoryCriterionDao();
    private MarkDao markDao = new InMemoryMarkDao();
    private VectorDao vectorDao = new InMemoryVectorDao();

    public Iterable<Vector> findAll()
    {
        Iterable<dao.Vector> vectors = vectorDao.findAll();
        Map<Long, List<dao.Vector>> vectorsByAltId = StreamSupport.stream(vectors.spliterator(), false)
                .collect(Collectors.groupingBy(
                        dao.Vector::getAltId, Collectors.toList()
                ));
    }
}
