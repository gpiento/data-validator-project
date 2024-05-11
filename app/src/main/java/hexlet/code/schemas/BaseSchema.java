package hexlet.code.schemas;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    /**
     * A map of check predicates for validating values.
     */
    private final HashMap<String, Predicate<T>> checkPredicates;

    protected BaseSchema() {
        checkPredicates = new LinkedHashMap<>();
    }

    /**
     * Adds a predicate to the list of check predicates.
     *
     * @param key       the key for the predicate
     * @param predicate the predicate to be added
     */
    public final void addPredicate(final String key,
                                   final Predicate<T> predicate) {
        checkPredicates.put(key, predicate);
    }

    /**
     * A method to check the validity of a given value based on a list of predicates.
     *
     * @param value the object value to be validated
     * @return true if the value is valid based on all predicates, false otherwise
     */
    public final boolean isValid(final T value) {
        return checkPredicates
                .values()
                .stream()
                .allMatch(predicate -> predicate.test(value));
    }
}
