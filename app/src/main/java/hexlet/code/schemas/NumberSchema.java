package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {

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
        addPredicate("range", number -> {
            if (number instanceof Integer) {
                return (Integer) number >= min && (Integer) number <= max;
            }
            return true;
        });
        return this;
    }

    /**
     * A description of the entire Java function.
     *
     * @return description of return value
     */
    public NumberSchema positive() {
        addPredicate("positive", number -> {
            if (number instanceof Integer) {
                return (Integer) number > 0;
            } else if (number instanceof Double) {
                return (Double) number > 0;
            } else if (number instanceof Float) {
                return (Float) number > 0;
            } else if (number instanceof Long) {
                return (Long) number > 0;
            } else if (number instanceof Byte) {
                return (Byte) number > 0;
            } else if (number instanceof Short) {
                return (Short) number > 0;
            }
            return true;
        });
        return this;
    }
}
