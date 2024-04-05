package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Number> {

    public NumberSchema required() {
        Predicate<Number> predicate = Objects::nonNull;
        addPredicate(predicate);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Number> predicate = number -> {
            if (number == null) {
                return true;
            }
            if (number instanceof Integer) {
                return number.intValue() > 0;
            } else if (number instanceof Long) {
                return number.longValue() > 0;
            } else if (number instanceof Float) {
                return number.floatValue() > 0;
            } else if (number instanceof Double) {
                return number.doubleValue() > 0;
            } else if (number instanceof Short) {
                return number.shortValue() > 0;
            } else if (number instanceof Byte) {
                return number.byteValue() > 0;
            }
            return false;
        };
        addPredicate(predicate);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Number> predicate = number ->
                number == null
                        || (number.doubleValue() >= min
                        && number.doubleValue() <= max);
        addPredicate(predicate);
        return this;
    }
}
