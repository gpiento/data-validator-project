package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema<Object> {

    public final MapSchema required() {
        addPredicate("required", Objects::nonNull);
        return this;
    }

    public final MapSchema sizeof(final int size) {
        addPredicate("sizeof", map -> ((Map<?, ?>) map).size() == size);
        return this;
    }

    public final MapSchema shape(final Map<String, BaseSchema> shape) {
        addPredicate("shape", map ->
                shape.entrySet().stream().allMatch(value -> {
                    Object object = ((Map<?, ?>) map).get(value.getKey());
                    return value.getValue().isValid(object);
                }));
        return this;
    }
}
