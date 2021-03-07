package service;

import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.model.EmployeeTable;
import com.paypal.bfs.test.employeeserv.parser.EmployeeParser;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static data.TestData.TEST_EMPLOYEE;
import static data.TestData.TEST_EMPLOYEE_TABLE;
import static org.mockito.Mockito.when;

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
    void testById_empty() {
        when(employeeParser.toJSON(ArgumentMatchers.any()))
                .thenReturn(new Employee());

        Optional<Employee> result = employeeService.byId(1L);
        Assertions.assertEquals(Optional.empty(), result);
    }

    @Test
    void testById() {
        when(employeeParser.toJSON(ArgumentMatchers.any()))
                .thenReturn(new Employee());
        when(employeeRepository.findById(1l))
                .thenReturn(Optional.ofNullable(TEST_EMPLOYEE_TABLE));
        when(employeeParser.toJSON(TEST_EMPLOYEE_TABLE))
                .thenReturn(TEST_EMPLOYEE);

        Optional<Employee> result = employeeService.byId(1L);
        Assertions.assertEquals(Optional.of(TEST_EMPLOYEE), result);
    }


    @Test
    void testCreate() {
        when(employeeParser.toObject(ArgumentMatchers.any())).thenReturn(new EmployeeTable(1L, "first_name", "last_name", "date_of_birth", "address_line1", "address_line2", "city", "state", "country", "zip_code"));

        boolean result = employeeService.create(new Employee());
        Assertions.assertEquals(true, result);
    }
}
