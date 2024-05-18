package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    /**
     * A map of check predicates for validating values.
     */
    private final List<Predicate> checkPredicates = new ArrayList<>();

    /**
     * A flag to indicate if the value is required.
     */
    protected boolean isRequired = false;

    /**
     * Adds a predicate to the list of check predicates.
     *
     * @param predicate the predicate to be added
     */
    public final void addPredicate(Predicate predicate) {
        checkPredicates.add(predicate);
    }

    /**
     * Sets the required flag.
     *
     * @param isRequired the required flag value
     */
    public final void setRequired(final boolean isRequired) {
        this.isRequired = isRequired;
    }

    /**
     * A method to check the validity of a given value based on a list of
     * predicates.
     *
     * @param value the object value to be validated
     * @return true if the value is valid based on all predicates, false
     * otherwise
     */
    public boolean isValid(final Object value) {
        if (value == null || value.equals("")) {
            return !isRequired;
        } else {
            for (Predicate predicate : checkPredicates) {
                if (!predicate.test(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
