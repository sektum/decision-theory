package web;

import dao.ComparisonDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResultServlet extends HttpServlet {
    ComparisonDao comparisonDao = new ComparisonDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("results", comparisonDao.getComparisonMatrix().getResults());
        req.getRequestDispatcher("/WEB-INF/pages/results.jsp").forward(req, resp);
    }
}
