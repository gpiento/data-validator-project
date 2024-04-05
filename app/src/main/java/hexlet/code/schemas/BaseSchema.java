package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private final List<Predicate> predicates = new ArrayList<>();

    public void addPredicate(Predicate predicate) {

        predicates.add(predicate);
    }

    public boolean isValid(T value) {

        for (Predicate<T> predicate : predicates) {
            if (!predicate.test(value)) {
                return false;
            }
        }
        return true;
    }
}
