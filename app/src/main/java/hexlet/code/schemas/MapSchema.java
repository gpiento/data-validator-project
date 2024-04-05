package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Object> {

    public MapSchema required() {
        Predicate<Map<?, ?>> predicate = m -> m instanceof Map<?, ?>;
        addPredicate(predicate);
        return this;
    }

    public MapSchema sizeof(int size) {

        Predicate<HashMap<?, ?>> predicate = m -> m.size() == size;
        addPredicate(predicate);
        return this;
    }
}
