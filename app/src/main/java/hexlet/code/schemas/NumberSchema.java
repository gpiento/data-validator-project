package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    /**
     * A description of the entire Java function.
     *
     * @return description of return value
     */
    public NumberSchema required() {
        addPredicate("required", Objects::nonNull);
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
        addPredicate("range", n -> n >= min && n <= max);
        return this;
    }

    /**
     * A description of the entire Java function.
     *
     * @return description of return value
     */
    public NumberSchema positive() {
        addPredicate("positive", number -> number > 0);
        return this;
    }
}
