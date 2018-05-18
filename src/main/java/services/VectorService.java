package services;

import dao.AlternativeDao;
import dao.CriterionDao;
import dao.MarkDao;
import dao.VectorDao;
import dao.jdbc.JdbcAlternativeDao;
import dao.jdbc.JdbcCriterionDao;
import dao.jdbc.JdbcMarkDao;
import dao.jdbc.JdbcVectorDao;
import dto.VectorDto;
import entities.Criterion;
import entities.Mark;
import entities.Vector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class VectorService {
    private AlternativeDao alternativeDao = new JdbcAlternativeDao();
    private CriterionDao criterionDao = new JdbcCriterionDao();
    private MarkDao markDao = new JdbcMarkDao();
    private VectorDao vectorDao = new JdbcVectorDao();

    public Iterable<VectorDto> findAll(){
        Iterable<Vector> vectors = vectorDao.findAll();
        Map<Long, List<Vector>> vectorsByAltId = StreamSupport.stream(vectors.spliterator(), false)
                .collect(Collectors.groupingBy(
                        Vector::getAltId, Collectors.toList()
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
