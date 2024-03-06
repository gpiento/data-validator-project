package hexlet.code;

public class Validator {

    public static void main(String[] args) {

        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("hex");
        schema.isValid("hello"); // false
        schema.isValid("hexlet"); // true}
    }

    public StringSchema string() {

        return new StringSchema();
    }
}
