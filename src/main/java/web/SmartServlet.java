package web;

import processes.SmartProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SmartServlet extends HttpServlet {
    private SmartProcess smartProcess = new SmartProcess();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("smartPairs", smartProcess.getPairs());
        req.getRequestDispatcher("/WEB-INF/pages/smart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[][] matrix = new String[5][5];
        String choice = req.getParameter("choice");
        System.out.println(choice);

    }
}
