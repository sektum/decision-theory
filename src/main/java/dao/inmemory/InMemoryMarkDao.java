package dao.inmemory;

import dao.MarkDao;
import entities.Mark;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryMarkDao implements MarkDao {
    private static final List<Mark> MARKS;
    static {
        MARKS = Arrays.asList(
                new Mark(1, 1, "1000", 1, 1000, 1000),
                new Mark(2, 2, "100", 1, 100, 100)
        );
    }

    @Override
    public Iterable<Mark> findByCritId(long critId) {
        return MARKS.stream()
                .filter(mark -> critId == mark.getCritId())
                .collect(Collectors.toList());
    }

    @Override
    public Mark findById(long markId) {
        return MARKS.stream().filter(mark -> mark.getId() == markId).findFirst().orElse(null);
    }
}
