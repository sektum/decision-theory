package web;

import services.VectorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VectorServlet extends HttpServlet {
    private VectorService vectorService = new VectorService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("vectors", vectorService.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/vectors.jsp").forward(req, res);
    }
}
