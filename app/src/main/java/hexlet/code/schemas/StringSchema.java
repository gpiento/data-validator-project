package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    /**
     * Constructs a new instance of the StringSchema class.
     */
    public StringSchema() {
        Predicate<Object> predicate = x -> x instanceof String;
        addPredicate(predicate);
    }

    /**
     * Adds a predicate to check if the input String is not null and not empty.
     *
     * @return the current StringSchema object
     */
    public StringSchema required() {
        setRequired(true);
        return this;
    }

    /**
     * Adds a predicate to check if the input String has a minimum length.
     *
     * @param length the minimum length of the input String
     * @return the current StringSchema object
     */
    public StringSchema minLength(final int length) {
        Predicate<String> predicate = s -> s.length() >= length;
        addPredicate(predicate);
        return this;
    }

    /**
     * Adds a predicate to check if the input String contains the specified
     * substring.
     *
     * @param substring the substring to check for in the input String
     * @return the current StringSchema object
     */
    public StringSchema contains(final String substring) {
        Predicate<String> predicate = s -> s.contains(substring);
        addPredicate(predicate);
        return this;
    }
}
