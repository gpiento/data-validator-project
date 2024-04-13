package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private final List<Predicate> predicates;

    public BaseSchema() {

        predicates = new ArrayList<>();
    }

    public void addPredicate(final Predicate predicate) {

        predicates.add(predicate);
    }

    public boolean isValid(final T value) {

        for (Predicate predicate : predicates) {
            if (!predicate.test(value)) {
                return false;
            }
        }
        return true;
    }
}
