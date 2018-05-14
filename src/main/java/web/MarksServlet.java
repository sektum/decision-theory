package web;

import services.CriterionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MarksServlet extends HttpServlet {
    private CriterionService criterionService = new CriterionService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("criteria", criterionService.findWithMarks());
        req.getRequestDispatcher("/WEB-INF/pages/marks.jsp").forward(req, res);
    }
}
