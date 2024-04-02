package hexlet.code;

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
    void allValidations() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("hex");
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid("hex"));
        assertFalse(schema.isValid(""));
    }
}
