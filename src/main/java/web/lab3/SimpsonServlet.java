package web.lab3;


import dao.AlternativeDao;
import dao.jdbc.JdbcAlternativeDao;
import entities.Simpson;
import org.apache.commons.lang3.tuple.Pair;
import processes.SimpsonProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;


public class SimpsonServlet extends HttpServlet {
    SimpsonProcess simpsonProcess = new SimpsonProcess();
    AlternativeDao alternativeDao = new JdbcAlternativeDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Pair<String, String>, Long> results = simpsonProcess.getSimpsonList().stream()
                .map(s -> new AbstractMap.SimpleEntry<>(
                        Pair.of(getName(s.getPair().getKey()), getName(s.getPair().getValue())), s.getCount()
                ))
                .sorted(comparing(Map.Entry::getValue, reverseOrder()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        req.setAttribute("results", results);
        req.setAttribute("winners", findWinners(results));
        req.getRequestDispatcher("/WEB-INF/pages/simpson.jsp").forward(req, resp);
    }

    private String getName(long id)
    {
        return alternativeDao.findById(id).getName();
    }

    private List<String> findWinners(Map<Pair<String, String>, Long> results)
    {
        Long bestCount = results.get(new ArrayList<>(results.keySet()).get(0));

        return results.entrySet().stream()
                .filter(e -> e.getValue().equals(bestCount))
                .map(e -> e.getKey().getLeft())
                .collect(toList());
    }
}
