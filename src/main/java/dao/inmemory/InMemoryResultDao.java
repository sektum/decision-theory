package dao.inmemory;

import dao.ResultDao;
import entities.Result;

import java.util.ArrayList;
import java.util.List;

public class InMemoryResultDao implements ResultDao {
    private static List<Result> results = new ArrayList<>();

    @Override
    public List<Result> findAllByAltName(String altName) {
        return results;
    }

    @Override
    public List<Result> findAllByLpr(int idLpr) {
        return results;
    }

    @Override
    public void save(Result result) {
        results.add(result);
    }
}
