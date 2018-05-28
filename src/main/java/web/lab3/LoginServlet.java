package web.lab3;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static javax.servlet.http.HttpServletResponse.SC_OK;

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        String lprId = req.getParameter("lpr");
        req.getSession().setAttribute("lpr", lprId);

        resp.setStatus(SC_OK);
    }
}
