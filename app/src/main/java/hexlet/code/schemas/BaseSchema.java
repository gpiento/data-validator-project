package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    /**
     * A map of check predicates for validating values.
     */
    private final Map<String, Predicate<T>> checkPredicates = new LinkedHashMap<>();

    /**
     * A flag to indicate if the value is required.
     */
    protected boolean isRequired = false;

    /**
     * Adds a predicate to the list of predicates.
     *
     * @param name      the name of the predicate
     * @param predicate the predicate to be added
     */
    public final void addPredicate(final String name, final Predicate<T> predicate) {
        checkPredicates.put(name, predicate);
    }

    /**
     * A method to check the validity of a given value based on a list of
     * predicates.
     *
     * @param value the object value to be validated
     * @return true if the value is valid based on all predicates, false
     * otherwise
     */
    public boolean isValid(final T value) {
        if (value == null || value.equals("")) {
            return !isRequired;
        } else {
            for (Predicate<T> predicate : checkPredicates.values()) {
                if (!predicate.test(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
