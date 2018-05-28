package utils;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ListUtils {
    public static <T> List<T> exclude(T elem, List<T> list)
    {
        return list.stream()
                .filter(e -> !e.equals(elem))
                .collect(toList());
    }
}
