package services;

import dao.AlternativeDao;
import dao.CriterionDao;
import dao.MarkDao;
import dao.VectorDao;
import dao.jdbc.JdbcAlternativeDao;
import dao.jdbc.JdbcCriterionDao;
import dao.jdbc.JdbcMarkDao;
import dao.jdbc.JdbcVectorDao;
import dto.SmartDto;

import entities.Criterion;
import entities.Mark;
import entities.Vector;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartService {
    private AlternativeDao alternativeDao = new JdbcAlternativeDao();
    private CriterionDao criterionDao = new JdbcCriterionDao();
    private MarkDao markDao = new JdbcMarkDao();
    private VectorDao vectorDao = new JdbcVectorDao();

    public Iterable<SmartDto> getPairs() {
        //Get pairs face-to-face Id + Vector -> convertToDto
        //Make List of SmartDto
        return null;
    }
    private SmartDto convertToDto(long altFirstId, long altSecondId, Vector firstVector, Vector secondVector){
        String altName = new StringBuilder()
                .append(alternativeDao.findById(altFirstId).getName())
                .append(" VS ")
                .append(alternativeDao.findById(altSecondId).getName())
                .toString();
        Map<String, List<String>> pairs = new HashMap<>();
        List<String> marks = new ArrayList<>();
        //Get Vectro1 and Vector2 -> Map <Criterion1, List<Mark1, Mark2>
        return new SmartDto(altName, pairs);
    }
}
