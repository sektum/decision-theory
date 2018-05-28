package web;

import dao.AlternativeDao;
import dao.ResultDao;
import dao.jdbc.JdbcAlternativeDao;
import dao.jdbc.JdbcResultDao;
import entities.Result;

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

public class ResultServlet extends HttpServlet {
    private ResultDao resultDao = new JdbcResultDao();
    private AlternativeDao alternativeDao = new JdbcAlternativeDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Result> resultsList =  resultDao.findAllByLpr((int) req.getSession().getAttribute("lpr"));
        Map<String, Long> results = resultsList.stream()
                .map(result -> new AbstractMap.SimpleEntry<>(alternativeDao.findById(result.getIdAlt()).getName(), result.getAWeight()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        req.setAttribute("results", results);
        req.getRequestDispatcher("/WEB-INF/pages/results.jsp").forward(req, resp);
    }
}
