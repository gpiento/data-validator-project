package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        Predicate<String> predicate = s -> s != null && !s.isEmpty();
        predicates.add(predicate);
        return this;
    }

    public StringSchema minLength(int length) {

        Predicate<String> predicate = s -> s.length() >= length;
        predicates.add(predicate);
        return this;
    }

    public StringSchema contains(String substring) {

        Predicate<String> predicate = s -> s.contains(substring);
        predicates.add(predicate);
        return this;
    }
}