package web.lab3;

import dao.AlternativeDao;
import dao.ComparisonDao;
import dao.ResultDao;
import dao.jdbc.JdbcAlternativeDao;
import dao.jdbc.JdbcResultDao;
import entities.Result;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveResultsServlet extends HttpServlet {
    private ResultDao resultDao = new JdbcResultDao();
    private ComparisonDao comparisonDao = new ComparisonDao();
    private AlternativeDao alternativeDao = new JdbcAlternativeDao();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        comparisonDao.getComparisonMatrix().getResults().entrySet().forEach(e -> {
            String altName = e.getKey();
            long altWeight = e.getValue();
            long altId = alternativeDao.findByName(altName);
            resultDao.save(
                    Result.builder()
                            .idAlt(altId)
                    .aWeight(altWeight)
                    .idLpr((int) req.getSession().getAttribute("lpr"))
                    .build()
            );
        });
    }
}
