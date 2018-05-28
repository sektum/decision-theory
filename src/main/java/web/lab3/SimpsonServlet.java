package web.lab3;



import org.apache.commons.lang3.tuple.Pair;
import processes.SimpsonProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SimpsonServlet extends HttpServlet {
    SimpsonProcess simpsonProcess = new SimpsonProcess();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Pair<String, String>, Long> results = new HashMap<>();
        req.setAttribute("results", results);
        req.getRequestDispatcher("/WEB-INF/pages/simpson.jsp").forward(req, resp);
    }
}
