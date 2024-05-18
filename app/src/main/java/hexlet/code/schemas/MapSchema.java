package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    /**
     * A description of the entire Java function.
     *
     * @return description of return value
     */
    public MapSchema() {
        Predicate<Object> predicate = x -> x instanceof Map;
        addPredicate(predicate);
    }

    /**
     * Adds a predicate to check if the map is not null.
     *
     * @return the current MapSchema object
     */
    public MapSchema required() {
        setRequired(true);
        return this;
    }

    /**
     * Adds a predicate to check if the map has the specified size.
     *
     * @param size the expected size of the map
     * @return the current MapSchema object
     */
    public MapSchema sizeof(final int size) {
        Predicate<Map<?, ?>> predicate = m -> m.size() == size;
        addPredicate(predicate);
        return this;
    }

    /**
     * Adds a predicate to check the shape of the map based on the provided
     * shape.
     *
     * @param shape the shape to check against the map
     * @return the current MapSchema object
     */
    public MapSchema shape(final Map<String, BaseSchema> shape) {
        Predicate<Map<?, ?>> predicate = m -> {
            for (Map.Entry<String, BaseSchema> entry : shape.entrySet()) {
                Object object = m.get(entry.getKey());
                if (!entry.getValue().isValid(object)) {
                    return false;
                }
            }
            return true;
        };
        addPredicate(predicate);
        return this;
    }
}
