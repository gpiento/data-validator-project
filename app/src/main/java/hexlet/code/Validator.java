package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    public static void main(String[] args) {

        Validator v = new Validator();
        BaseSchema<String> schema = v.string().required().minLength(5).contains("hex");
        System.out.println(schema.isValid("")); // false
        System.out.println(schema.isValid("asdfsdsd")); // false
        System.out.println(schema.isValid("asdhexsdf")); // true

    }

    public StringSchema string() {

        return new StringSchema();
    }

    public NumberSchema number() {

        return new NumberSchema();
    }

    public MapSchema map() {

        return new MapSchema();
    }
}
