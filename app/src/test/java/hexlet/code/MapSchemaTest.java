package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    void shape() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));

        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));
    }
}
