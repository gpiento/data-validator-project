package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Object> {

    public final MapSchema required() {
        Predicate<Map<?, ?>> predicate = m -> m instanceof Map<?, ?>;
        addPredicate(predicate);
        return this;
    }

    public final MapSchema sizeof(int size) {

        Predicate<Map<?, ?>> predicate = m -> m.size() == size;
        addPredicate(predicate);
        return this;
    }

    public final <T> MapSchema shape(Map<String, BaseSchema<T>> shape) {

        Predicate<Map<?, ?>> predicate = m -> shape.entrySet().stream().allMatch(e -> {
            Object value = m.get(e.getKey());
            BaseSchema schema = e.getValue();
            return schema.isValid(value);
        });
        addPredicate(predicate);
        return this;
    }
}
