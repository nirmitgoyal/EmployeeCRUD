package impl;

import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.impl.EmployeeResourceImpl;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.util.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static data.TestData.TEST_EMPLOYEE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

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
    void testEmployeeGetById_notFound() {
        when(employeeService.byId(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Employee> result = employeeResourceImpl.employeeGetById(1L);
        assertEquals(new ResponseEntity<>(NOT_FOUND), result);
    }

    @Test
    void testEmployeeGetById_found() {
        when(employeeService.byId(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(TEST_EMPLOYEE));

        ResponseEntity<Employee> result = employeeResourceImpl.employeeGetById(1L);
        assertEquals(new ResponseEntity<>(TEST_EMPLOYEE, OK), result);
    }

    @Test
    void testCreateEmployee() {
        when(employeeService.byId(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());
        when(employeeService.create(ArgumentMatchers.any())).thenReturn(true);
        when(validator.validate(ArgumentMatchers.any())).thenReturn(Optional.empty());

        ResponseEntity result = employeeResourceImpl.createEmployee(TEST_EMPLOYEE);
        assertEquals(ResponseEntity
                .status(CREATED)
                .body("Employee created"), result);
    }

    @Test
    void testCreateEmployee_forbidden() {
        when(employeeService.byId(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(TEST_EMPLOYEE));
        when(employeeService.create(ArgumentMatchers.any())).thenReturn(true);
        when(validator.validate(ArgumentMatchers.any())).thenReturn(Optional.empty());

        ResponseEntity result = employeeResourceImpl.createEmployee(TEST_EMPLOYEE);
        assertEquals(ResponseEntity
                .status(FORBIDDEN)
                .body("Employee already exists"), result);
    }
}
