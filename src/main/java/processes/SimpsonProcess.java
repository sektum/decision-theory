package processes;

import dao.PersonDao;
import dao.ResultDao;
import dao.jdbc.JdbcPersonDao;
import dao.jdbc.JdbcResultDao;
import entities.Person;
import entities.Result;
import entities.Simpson;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static utils.ListUtils.exclude;

public class SimpsonProcess {
    private ResultDao resultDao = new JdbcResultDao();
    private PersonDao personDao = new JdbcPersonDao();
    private List<Simpson> simpsons;
    private List<Result> results;

    public List<Simpson> getSimpsonList() {
        Iterable<Person> persons = personDao.findAll();
        simpsons = new ArrayList<>();
        for (Person person : persons) {
            results = resultDao.findAllByLpr(person.getId());
            addSimpsons(results);
        }
        for (Simpson simpson :
                simpsons) {
            System.out.println("(" + simpson.getPair().getLeft() + ", " + simpson.getPair().getRight() + ") x" + simpson.getCount());
        }
        minPairForIdAlt(simpsons);
        return simpsons;
    }

    void addSimpsons(List<Result> results) {
        for (int i = 0; i < results.size() - 1; i++) {
            for (int j = i + 1; j < results.size(); j++) {
                Pair<Long, Long> pair = Pair.of(results.get(i).getIdAlt(), results.get(j).getIdAlt());
                if (findPair(pair) == null) {
                    simpsons.add(new Simpson(pair, 1));
                } else {
                    findPair(pair).incrementCount();
                }
            }
        }
        /*добавить пару в лист simpsons в цикле - (левый элемент=текущий, правый=все последующие)
          и проверить, если такая пара уже есть в simpsons, просто прибавить в ней count++
          если нету - установить count = 1
         */
    }

    private Simpson findPair(Pair<Long, Long> pair) {
        return simpsons.stream()
                .filter(simpson -> simpson.getPair().equals(pair))
                .findAny()
                .orElse(null);
    }

    private void minPairForIdAlt(List<Simpson> simpsons) {
        List<Simpson> copy = new ArrayList<>(simpsons);
        for(int i = 1; i <= results.size(); i++) {
            long count = Long.MAX_VALUE;
            Simpson currentMin = null;
            for (Simpson simpson :
                    copy) {
                if(simpson.getPair().getLeft() == i){
                    if(simpson.getCount() < count){
                        if(currentMin != null & simpsons.contains(currentMin))
                            simpsons.remove(currentMin);
                        count = simpson.getCount();
                        currentMin = simpson;
                    }
                    else simpsons.remove(simpson);
                }
            }
        }
    }
}
