package processes;

import dao.PersonDao;
import dao.ResultDao;
import dao.jdbc.JdbcPersonDao;
import dao.jdbc.JdbcResultDao;
import entities.Person;
import entities.Result;
import entities.Simpson;

import java.util.ArrayList;
import java.util.List;

public class SimpsonProcess {
    ResultDao resultDao = new JdbcResultDao();
    PersonDao personDao = new JdbcPersonDao();
    List<Simpson> simpsons;

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

    private static void addSimpsons(List<Result> results){
        /*добавить пару в лист simpsons в цикле - (левый элемент=текущий, правый=все последующие)
          и проверить, если такая пара уже есть в simpsons, просто прибавить в ней count++
          если нету - установить count = 1
         */
    }
}
