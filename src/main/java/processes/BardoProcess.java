package processes;

import dao.AlternativeDao;
import dao.ResultDao;
import dao.jdbc.JdbcAlternativeDao;
import dao.jdbc.JdbcResultDao;
import entities.Alternative;
import entities.Bardo;
import entities.Result;

import java.util.ArrayList;
import java.util.List;

public class BardoProcess {
    ResultDao resultDao = new JdbcResultDao();
    AlternativeDao alternativeDao = new JdbcAlternativeDao();
    List<Bardo> bardos;
    List<Bardo> winner;
    long maxWeight = Integer.MIN_VALUE;

    public List<Bardo> getBardoList() {
        Iterable<Alternative> alternatives = alternativeDao.findAll();
        bardos = new ArrayList<>();
        for (Alternative alternative : alternatives) {
            List<Result> results;
            results = resultDao.findAllByAltName(alternative.getName());
            long weight = 0;
            long id = 0;
            for (Result result : results) {
                weight += result.getAWeight();
                id = result.getIdAlt();
            }
            bardos.add(new Bardo(id, weight));
        }
        return bardos;
    }

    public List<Bardo> getWinner(){
        for (Bardo bardo: bardos) {
            if(bardo.getAWeight() > maxWeight) maxWeight = bardo.getAWeight();
        }
        winner = new ArrayList<>();
        for (Bardo bardo: bardos) {
            if(bardo.getAWeight() == maxWeight) winner.add(bardo);
        }
        return winner;
    }
}
