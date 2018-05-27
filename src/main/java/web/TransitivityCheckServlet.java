package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ComparisonDao;
import models.ComparisonResult;
import org.apache.commons.lang3.tuple.Pair;
import processes.TransitivityCheck;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransitivityCheckServlet extends HttpServlet {
    private TransitivityCheck transitivityCheck = new TransitivityCheck();
    private ComparisonDao comparisonDao = new ComparisonDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Pair<Boolean, Map<ComparisonResult, List<String>>> result = transitivityCheck.isHolds(comparisonDao.getComparisonMatrix());
        Map<String, Object> responseString = new HashMap<>();
        responseString.put("valid", result.getKey());
        responseString.put("errors", result.getValue());
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(responseString));
    }
}
