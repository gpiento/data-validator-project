package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    /**
     * Ensures that the string value is not null or empty.
     *
     * @return the updated StringSchema instance
     */
    public StringSchema required() {
        addPredicate((Object s) -> s != null && !s.toString().isEmpty());
        return this;
    }

    /**
     * Ensures that the string value has a minimum length.
     *
     * @param length the minimum length
     * @return the updated StringSchema instance
     */
    public StringSchema minLength(final int length) {

        addPredicate((Object s) -> s.toString().length() >= length);
        return this;
    }

    /**
     * Ensures that the string value contains the specified substring.
     *
     * @param substring the substring to search for
     * @return the updated StringSchema instance
     */
    public StringSchema contains(final String substring) {

        addPredicate((Object s) -> s.toString().contains(substring));
        return this;
    }
}
