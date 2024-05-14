package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema {

    /**
     * Adds a predicate to check if the map is not null.
     *
     * @return the current MapSchema object
     */
    public final MapSchema required() {
        addPredicate("required", Objects::nonNull);
        return this;
    }

    /**
     * Adds a predicate to check if the map has the specified size.
     *
     * @param size the expected size of the map
     * @return the current MapSchema object
     */
    public final MapSchema sizeof(final int size) {
        addPredicate("sizeof", map -> ((Map<?, ?>) map).size() == size);
        return this;
    }

    /**
     * Adds a predicate to check the shape of the map based on the provided
     * shape.
     *
     * @param shape the shape to check against the map
     * @return the current MapSchema object
     */
    public final MapSchema shape(final Map<String, BaseSchema> shape) {
        addPredicate("shape", map ->
                shape.entrySet().stream().allMatch(value -> {
                    Object object = ((Map<?, ?>) map).get(value.getKey());
                    return value.getValue().isValid(object);
                }));
        return this;
    }
}
