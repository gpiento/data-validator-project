## Data Validator

[![hexlet-check](https://github.com/gpiento/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/gpiento/java-project-78/actions/workflows/hexlet-check.yml)
[![GitHub Workflow Status](https://github.com//gpiento/java-project-78/actions/workflows/github-check.yml/badge.svg)](https://github.com/gpiento/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/5409c5fc72a5aacbfc38/maintainability)](https://codeclimate.com/github/gpiento/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/5409c5fc72a5aacbfc38/test_coverage)](https://codeclimate.com/github/gpiento/java-project-78/test_coverage)

A data validator is a library that can be used to check the correctness of any data. There are many such libraries in every language, because almost all programs work with external data that need to be checked for correctness. First of all, we are talking about form data filled in by users. The yup library is taken as a basis for the project.

### Valid data types:
- String
- Integer
- Map

### Example of using strings:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

var v = new Validator();

var schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false

var schema1 = v.string();
schema1.minLength(10).minLength(4).isValid("Hexlet"); // true
```

### Example of using integers:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

var v = new Validator();

var schema = v.number();

schema.isValid(5); // true

schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10); // true

schema.isValid(-10); // false
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```

### Example of using maps:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

var v = new Validator();

var schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(new HashMap<>()); // true
var data = new HashMap<String, String>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```
