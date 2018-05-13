package web;

import dao.AlternativeDao;
import entities.Alternative;
import entities.InMemoryAlternativeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    private AlternativeDao alternativeDao = new InMemoryAlternativeDao();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Iterable<Alternative> alternatives = alternativeDao.findAll();
        req.setAttribute("alternatives", alternatives);
        req.setAttribute("name", "lera");
        req.getRequestDispatcher("/WEB-INF/pages/alternatives.jsp").forward(req, resp);
    }
}
