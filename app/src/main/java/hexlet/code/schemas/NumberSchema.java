package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    /**
     * Constructs a new instance of the NumberSchema class.
     */
    public NumberSchema() {
        Predicate<Integer> predicate = x -> x instanceof Integer;
        addPredicate("integer", predicate);
    }

    /**
     * A description of the entire Java function.
     *
     * @return description of return value
     */
    public NumberSchema required() {
        setRequired(true);
        return this;
    }

    /**
     * A description of the entire Java function.
     *
     * @param min description of parameter
     * @param max description of parameter
     * @return description of return value
     */
    public NumberSchema range(final int min, final int max) {
        Predicate<Integer> predicate = n -> n >= min && n <= max;
        addPredicate("range", predicate);
        return this;
    }

    /**
     * A description of the entire Java function.
     *
     * @return description of return value
     */
    public NumberSchema positive() {
        Predicate<Integer> predicate = n -> n > 0;
        addPredicate("positive", predicate);
        return this;
    }
}
