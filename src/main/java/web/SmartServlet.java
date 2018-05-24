package web;

import dto.SmartDto;
import javafx.util.Pair;
import processes.SmartProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SmartServlet extends HttpServlet {
    private SmartProcess smartProcess = new SmartProcess();
    private SmartDto smartDto = new SmartDto();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("smartPairs", smartProcess.getPairs());
        req.getRequestDispatcher("/WEB-INF/pages/smart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        smartDto.getMatrix().put(new Pair<>(req.getParameter("alt1"), req.getParameter("alt2")), req.getParameter("operation"));
        //here
    }
}
