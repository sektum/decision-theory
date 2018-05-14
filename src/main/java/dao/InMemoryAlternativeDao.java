package dao;

import entities.Alternative;

import java.util.Arrays;
import java.util.List;

public class InMemoryAlternativeDao implements AlternativeDao {
    private static final List<Alternative> ALTERNATIVES;
    static {
        ALTERNATIVES = Arrays.asList(
                new Alternative(1, "Lenovo Yoga"),
                new Alternative(2, "Macbook Pro")
        );
    }
    public Iterable<Alternative> findAll() {
        return ALTERNATIVES;
    }

    @Override
    public Alternative findById(long id) {
        return ALTERNATIVES.stream().filter(alt -> alt.getId() == id).findFirst().orElse(null);
    }
}
