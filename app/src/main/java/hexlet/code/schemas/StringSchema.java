package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    /**
     * Adds a predicate to check if the input String is not null and not empty.
     *
     * @return the current StringSchema object
     */
    public StringSchema required() {
        addPredicate("required", value -> value != null
                && !((String) value).isEmpty());
        return this;
    }

    /**
     * Adds a predicate to check if the input String has a minimum length.
     *
     * @param length the minimum length of the input String
     * @return the current StringSchema object
     */
    public StringSchema minLength(final int length) {
        addPredicate("minLength", s -> s != null
                && ((String) s).length() >= length);
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
        addPredicate("contains", s -> s != null
                && ((String) s).contains(substring));
        return this;
    }
}
