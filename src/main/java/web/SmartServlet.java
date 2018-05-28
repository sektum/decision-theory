package web;

import dao.ComparisonDao;
import dao.PersonDao;
import dao.jdbc.JdbcPersonDao;
import models.ComparisonResult;
import processes.SmartProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_OK;

public class SmartServlet extends HttpServlet {
    private SmartProcess smartProcess = new SmartProcess();
    private ComparisonDao comparisonDao = new ComparisonDao();
    private PersonDao personDao = new JdbcPersonDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        comparisonDao.clear();
        req.setAttribute("smartPairs", smartProcess.getPairs());
        req.setAttribute("lprs", personDao.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/smart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ComparisonResult result = ComparisonResult.fromSign(req.getParameter("operation"));
        comparisonDao.saveComparison(req.getParameter("alt1"), req.getParameter("alt2"), result);

        resp.setStatus(SC_OK);
    }
}
