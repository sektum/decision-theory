package entities;

import dao.AlternativeDao;

import java.util.Arrays;
import java.util.List;

public class InMemoryAlternativeDao implements AlternativeDao {
    private static final List<Alternative> ALTERNATIVES;
    static {
        ALTERNATIVES = Arrays.asList(new Alternative(1, "MS SQL Server"));
    }
    public Iterable<Alternative> findAll() {
        return ALTERNATIVES;
    }
}
