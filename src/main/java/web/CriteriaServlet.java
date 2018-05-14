package web;

import services.CriterionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CriteriaServlet extends HttpServlet {
    private CriterionService criterionService = new CriterionService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("criteria", criterionService.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/criteria.jsp").forward(req, res);
    }
}
