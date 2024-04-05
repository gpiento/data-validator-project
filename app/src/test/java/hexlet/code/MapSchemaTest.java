package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {

    @Test
    void valid() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<String, String>() {{
                put("key", "value");
            }}));
    }

    @Test
    void sizeof() {
        Validator v = new Validator();
        MapSchema schema = v.map().sizeof(2);
        assertTrue(schema.isValid(new HashMap<String, String>() {{
                put("key", "value");
                put("key2", "value2");
            }}));
        assertFalse(schema.isValid(new HashMap<String, String>() {{
                put("key3", "value3");
            }}));
    }

    @Test
    void required() {
        Validator v = new Validator();
        MapSchema schema = v.map().required();
        assertTrue(schema.isValid(new HashMap<>()));
        assertFalse(schema.isValid(null));
    }
}
