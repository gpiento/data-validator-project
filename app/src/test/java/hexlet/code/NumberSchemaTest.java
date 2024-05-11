package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {

    @Test
    void positive() {
        Validator v = new Validator();
        NumberSchema schema = v.number().positive();
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-1));
        assertFalse(schema.isValid(-1.0));
        assertTrue(schema.isValid(null));
    }

    @Test
    void required() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(null));
        schema.required();
        assertTrue(schema.isValid(123));
        assertFalse(schema.isValid(null));
    }

    @Test
    void range() {
        Validator v = new Validator();
        NumberSchema schema = v.number().range(5, 10);
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(15));
    }
}
