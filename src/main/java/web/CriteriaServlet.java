package web;

import dao.CriterionDao;
import dao.InMemoryCriterionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CriteriaServlet extends HttpServlet {
    private CriterionDao criterionDao = new InMemoryCriterionDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("criteria", criterionDao.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/criteria.jsp").forward(req, res);
    }
}
