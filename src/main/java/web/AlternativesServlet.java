package web;

import dao.AlternativeDao;
import dao.jdbc.JdbcAlternativeDao;
import entities.Alternative;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AlternativesServlet extends HttpServlet {
    private AlternativeDao alternativeDao = new JdbcAlternativeDao();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Iterable<Alternative> alternatives = alternativeDao.findAll();
        req.setAttribute("alternatives", alternatives);
        req.setAttribute("name", "lera");
        req.getRequestDispatcher("/WEB-INF/pages/alternatives.jsp").forward(req, resp);
    }
}
