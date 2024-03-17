package hexlet.code;

public class Validator {

    public static void main(String[] args) {

        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("hex");
        System.out.println(schema.isValid("")); // false
        System.out.println(schema.isValid("asdfsdsd")); // false
        System.out.println(schema.isValid("asdhexsdf")); // true}
    }

    public StringSchema string() {

        return new StringSchema();
    }
}
