package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    /**
     * Adds a predicate to check if the map is not null.
     *
     * @return the current MapSchema object
     */
    public MapSchema required() {
        addPredicate("required", Objects::nonNull);
        return this;
    }

    /**
     * Adds a predicate to check if the map has the specified size.
     *
     * @param size the expected size of the map
     * @return the current MapSchema object
     */
    public MapSchema sizeof(final int size) {
        addPredicate("sizeof", map -> map.size() == size);
        return this;
    }

    /**
     * Adds a predicate to check the shape of the map based on the provided
     * shape.
     *
     * @param shape the shape to check against the map
     * @return the current MapSchema object
     */
    public MapSchema shape(final Map<String, BaseSchema<Map<?, ?>>> shape) {
        addPredicate("shape", predicate ->
                shape.entrySet().stream().allMatch(entry -> {
                    Object object = predicate.get(entry.getKey());
                    return entry.getValue().isValid(object);
                }));

        return this;
    }
}
