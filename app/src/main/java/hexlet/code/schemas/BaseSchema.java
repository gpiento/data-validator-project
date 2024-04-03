package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

public class BaseSchema<T> {

    ArrayList<Predicate<T>> predicates = new ArrayList<>();

    public boolean isValid(T value) {

        for (Predicate<T> predicate : predicates) {
            if (!predicate.test(value)) {
                return false;
            }
        }
        return true;
    }
}
