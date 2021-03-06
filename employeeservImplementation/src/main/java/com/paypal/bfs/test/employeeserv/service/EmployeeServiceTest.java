package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.model.EmployeeTable;
import com.paypal.bfs.test.employeeserv.parser.EmployeeParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    EmployeeParser employeeParser;
    @InjectMocks
    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testById() {
        when(employeeParser.toJSON(any())).thenReturn(new Employee());

        Optional<Employee> result = employeeService.byId(Long.valueOf(1));
        Assertions.assertEquals(Optional.empty(), result);
    }

    @Test
    void testCreate() {
        when(employeeParser.toObject(any())).thenReturn(new EmployeeTable(Long.valueOf(1), "first_name", "last_name", "date_of_birth", "address_line1", "address_line2", "city", "state", "country", "zip_code"));

        boolean result = employeeService.create(new Employee());
        Assertions.assertEquals(true, result);
    }
}
