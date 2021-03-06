package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.util.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

class EmployeeResourceImplTest {
    @Mock
    EmployeeService employeeService;
    @Mock
    Validator validator;
    @InjectMocks
    EmployeeResourceImpl employeeResourceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testEmployeeGetById() {
        when(employeeService.byId(anyLong())).thenReturn(null);

        ResponseEntity<Employee> result = employeeResourceImpl.employeeGetById(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCreateEmployee() {
        when(employeeService.byId(anyLong())).thenReturn(null);
        when(employeeService.create(any())).thenReturn(true);
        when(validator.validate(any())).thenReturn(null);

        ResponseEntity result = employeeResourceImpl.createEmployee(new Employee());
        Assertions.assertEquals(null, result);
    }
}
