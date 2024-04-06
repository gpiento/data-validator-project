package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    /**
     * StringSchema.
     *
     * @return StringSchema()
     */
    public StringSchema string() {

        return new StringSchema();
    }

    /**
     * NumberSchema.
     *
     * @return NumberSchema()
     */
    public NumberSchema number() {

        return new NumberSchema();
    }

    /**
     * MapSchema.
     *
     * @return MapSchema()
     */
    public MapSchema map() {

        return new MapSchema();
    }
}
