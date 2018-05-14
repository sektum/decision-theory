package services;

import dao.*;
import dto.VectorDto;
import entities.Criterion;
import entities.Mark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class VectorService {
    private AlternativeDao alternativeDao = new InMemoryAlternativeDao();
    private CriterionDao criterionDao = new InMemoryCriterionDao();
    private MarkDao markDao = new InMemoryMarkDao();
    private VectorDao vectorDao = new InMemoryVectorDao();

    public Iterable<VectorDto> findAll()
    {
        Iterable<Vector> vectors = vectorDao.findAll();
        Map<Long, List<Vector>> vectorsByAltId = StreamSupport.stream(vectors.spliterator(), false)
                .collect(Collectors.groupingBy(
                        dao.Vector::getAltId, Collectors.toList()
                ));

        return vectorsByAltId.entrySet().stream()
                .map(e -> convertToDto(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private VectorDto convertToDto(long altId, List<Vector> vectors) {
        String altName = alternativeDao.findById(altId).getName();
        Map<String, String> marks = new HashMap<>();
        for (Vector v : vectors)
        {
            Mark mark = markDao.findById(v.getMarkId());
            Criterion crit = criterionDao.findById(mark.getCritId());
            marks.put(crit.getName(), mark.getName());
        }

        return new VectorDto(altName, marks);
    }
}
