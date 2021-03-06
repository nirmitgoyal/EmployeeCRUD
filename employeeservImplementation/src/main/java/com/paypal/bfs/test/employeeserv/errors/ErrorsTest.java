package com.paypal.bfs.test.employeeserv.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ErrorsTest {
    Errors errors = new Errors("field", "message");

    @Test
    void testBuilder() {
        Errors.ErrorsBuilder result = Errors.builder();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSetField() {
        errors.setField("field");
    }

    @Test
    void testSetMessage() {
        errors.setMessage("message");
    }
}
