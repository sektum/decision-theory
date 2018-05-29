package web.lab3;


import entities.Simpson;
import processes.SimpsonProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class SimpsonServlet extends HttpServlet {
    SimpsonProcess simpsonProcess = new SimpsonProcess();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Simpson> results = simpsonProcess.getSimpsonList();
        req.setAttribute("results", results);
        req.getRequestDispatcher("/WEB-INF/pages/simpson.jsp").forward(req, resp);
    }
}
