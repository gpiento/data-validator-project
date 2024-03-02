package hexlet.code;

public class StringSchema {

    private boolean required;
    private int minLength;
    private String contains;
    private boolean isValid;

    public StringSchema required() {

        required = true;
        return this;
    }

    public StringSchema minLength(int length) {

        minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {

        contains = substring;
        return this;
    }

    public StringSchema isValid() {
        return this;
    }
}
