package word.count.utils;

import java.util.function.Predicate;

public class PredicateUtils<T> {
    public static <T> Predicate<T> Not(Predicate<T> predicate) {
        return predicate.negate();
    }
}
