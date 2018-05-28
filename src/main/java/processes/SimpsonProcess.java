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
import java.util.List;
import java.util.Optional;

import static utils.ListUtils.exclude;

public class SimpsonProcess {
    ResultDao resultDao = new JdbcResultDao();
    PersonDao personDao = new JdbcPersonDao();
    List<Simpson> simpsons = new ArrayList<>();

    public List<Simpson> getSimpsonList() {
        Iterable<Person> persons = personDao.findAll();
        simpsons = new ArrayList<>();
        for (Person person : persons) {
            List<Result> results;
            results = resultDao.findAllByLpr(person.getId());
            addSimpsons(results);
        }
        //метод Симпсона
        return simpsons;
    }

    void addSimpsons(List<Result> results){
        for (Result outer : results)
        {
            for (Result inner : exclude(outer, results))
            {
                Pair<Long, Long> pair = Pair.of(outer.getIdAlt(), inner.getIdAlt());
                Simpson simpson = findPair(pair);
                if (simpson == null) {
                    simpsons.add(new Simpson(pair, 1));
                }
                else
                {
                    simpson.incrementCount();
                }
            }
        }
        /*добавить пару в лист simpsons в цикле - (левый элемент=текущий, правый=все последующие)
          и проверить, если такая пара уже есть в simpsons, просто прибавить в ней count++
          если нету - установить count = 1
         */
    }

    private Simpson findPair(Pair<Long, Long> pair)
    {
        return simpsons.stream()
                .filter(simpson -> simpson.getPair().equals(pair))
                .findAny()
                .orElse(null);
    }
}
