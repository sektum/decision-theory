package web.lab3;


import dao.AlternativeDao;
import dao.jdbc.JdbcAlternativeDao;
import entities.Bardo;
import processes.BardoProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;


public class BardoServlet extends HttpServlet {
    BardoProcess bardoProcess = new BardoProcess();
    AlternativeDao alternativeDao = new JdbcAlternativeDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Bardo> resultsList =  bardoProcess.getBardoList();
        Map<String, Long> results = resultsList.stream()
                .map(result -> new AbstractMap.SimpleEntry<>(alternativeDao.findById(result.getIdAlt()).getName(), result.getAWeight()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        List<Bardo> winnersList = bardoProcess.getWinner();
        Map<String, Long> winners = winnersList.stream()
                .map(result -> new AbstractMap.SimpleEntry<>(alternativeDao.findById(result.getIdAlt()).getName(), result.getAWeight()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        req.setAttribute("results", results);
        req.setAttribute("winners", winners);
        req.getRequestDispatcher("/WEB-INF/pages/bardo.jsp").forward(req, resp);
    }
}
