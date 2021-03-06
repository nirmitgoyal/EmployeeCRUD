package com.paypal.bfs.test.employeeserv.util;

import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.errors.Errors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

class ValidatorTest {
    @Mock
    List<Errors> errorsList;
    @InjectMocks
    Validator validator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testValidate() {
        Optional<List<Errors>> result = validator.validate(new Employee());
        Assertions.assertEquals(null, result);
    }
}
