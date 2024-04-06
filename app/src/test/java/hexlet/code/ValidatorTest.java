package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ValidatorTest {

    @Test
    public void testStringSchema() {
        Validator validator = new Validator();
        assertInstanceOf(StringSchema.class, validator.string());
    }

    @Test
    public void testNumberSchema() {
        Validator validator = new Validator();
        assertInstanceOf(NumberSchema.class, validator.number());
    }

    @Test
    public void testMapSchema() {
        Validator validator = new Validator();
        assertInstanceOf(MapSchema.class, validator.map());
    }
}
