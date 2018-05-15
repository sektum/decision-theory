package web;

import dao.PersonDao;
import dao.jdbc.JdbcPersonDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonsServlet extends HttpServlet {
    private PersonDao personDao = new JdbcPersonDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("persons", personDao.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/persons.jsp").forward(req, res);
    }
}
