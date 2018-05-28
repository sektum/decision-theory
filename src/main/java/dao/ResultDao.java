package dao;

import entities.Result;

import java.util.List;

public interface ResultDao {
   List<Result> findAllByAltName(String altName);
   List<Result> findAllByLpr(int idLpr);
   void save(Result result);
}
