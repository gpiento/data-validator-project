package hexlet.code;

import java.util.ArrayList;
import java.util.function.Predicate;

public class StringSchema {

    ArrayList<Predicate<String>> predicates = new ArrayList<>();

    public StringSchema required() {
        Predicate<String> predicate = s -> {
            return !s.isEmpty();
        };
        predicates.add(predicate);
        return this;
    }

    public StringSchema minLength(int length) {

        Predicate<String> predicate = s -> {
            return s.length() >= length;
        };
        predicates.add(predicate);
        return this;
    }

    public StringSchema contains(String substring) {

        Predicate<String> predicate = s -> {
            return s.contains(substring);
        };
        predicates.add(predicate);
        return this;
    }

    public boolean isValid(String string) {

        for (Predicate<String> predicate : predicates) {
            if (!predicate.test(string)) {
                return false;
            }
        }
        return true;
    }

}
