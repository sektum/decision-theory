package dao;

import java.util.Arrays;
import java.util.List;

public class InMemoryVectorDao implements VectorDao {
    private static final List<Vector> VECTORS;
    static {
        VECTORS = Arrays.asList(
                new Vector(1, 1, 1),
                new Vector(2, 1, 2),
                new Vector(3, 2, 1)
        );
    }

    @Override
    public Iterable<Vector> findAll() {
        return VECTORS;
    }
}
