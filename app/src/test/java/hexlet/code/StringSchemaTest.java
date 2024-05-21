package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {

    @Test
    void validation() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertTrue(schema.isValid("hexlet"));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }

    @Test
    void minLength() {
        Validator v = new Validator();
        StringSchema schema = v.string().minLength(5);
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid("hexl"));
    }

    @Test
    void required() {
        Validator v = new Validator();
        StringSchema schema = v.string().required();
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }

    @Test
    void contains() {
        Validator v = new Validator();
        StringSchema schema = v.string().contains("hex");
        assertTrue(schema.isValid("fhexlet"));
        assertFalse(schema.isValid("mex"));
    }

    @Test
    void allValidationString() {
        Validator v = new Validator();

        StringSchema schema = v.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));

        assertFalse(schema.isValid("what does the fox say"));

        assertFalse(schema.minLength(3).isValid("what"));
        assertFalse(schema.minLength(6).isValid("fox"));
        assertFalse(schema.minLength(5).isValid(null));

        assertFalse(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid("what"));

        assertFalse(schema.contains("what").isValid("what"));

        schema = v.string().required().minLength(5).contains("hex");
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid("hex"));
        assertFalse(schema.isValid(""));

    }
}
