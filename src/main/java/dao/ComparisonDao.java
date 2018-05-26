package dao;

import models.ComparisonMatrix;
import models.ComparisonResult;

public class ComparisonDao {
    private static ComparisonMatrix MATRIX = new ComparisonMatrix();

    public void saveComparison(String param1, String param2, ComparisonResult result)
    {
        MATRIX.put(param1, param2, result);
    }

    public ComparisonMatrix getComparisonMatrix()
    {
        return MATRIX;
    }
}
