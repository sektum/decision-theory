package web;

import dao.ComparisonDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MatrixServlet extends HttpServlet {
    private ComparisonDao comparisonDao = new ComparisonDao();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("matrix", comparisonDao.getComparisonMatrix());
        request.getRequestDispatcher("/WEB-INF/pages/matrix.jsp").forward(request, response);
    }
}
