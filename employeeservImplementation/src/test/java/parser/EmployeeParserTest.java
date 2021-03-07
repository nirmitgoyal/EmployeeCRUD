package parser;

import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeTable;
import com.paypal.bfs.test.employeeserv.parser.EmployeeParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static data.TestData.TEST_EMPLOYEE;
import static data.TestData.TEST_EMPLOYEE_TABLE;

class EmployeeParserTest {
    final EmployeeParser employeeParser = new EmployeeParser();

    @Test
    void testToObject() {
        EmployeeTable result = employeeParser.toObject(TEST_EMPLOYEE);
        Assertions.assertEquals(TEST_EMPLOYEE_TABLE, result);
    }

    @Test
    void testToJSON() {
        Employee result = employeeParser.toJSON(TEST_EMPLOYEE_TABLE);
        Assertions.assertEquals(TEST_EMPLOYEE, result);
    }
}
