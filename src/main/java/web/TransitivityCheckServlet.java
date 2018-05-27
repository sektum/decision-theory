package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ComparisonDao;
import processes.TransitivityCheck;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TransitivityCheckServlet extends HttpServlet {
    private TransitivityCheck transitivityCheck = new TransitivityCheck();
    private ComparisonDao comparisonDao = new ComparisonDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean isValid = transitivityCheck.isHolds(comparisonDao.getComparisonMatrix());
        Map<String, Object> responseString = new HashMap<>();
        responseString.put("valid", isValid);
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(responseString));
    }
}
