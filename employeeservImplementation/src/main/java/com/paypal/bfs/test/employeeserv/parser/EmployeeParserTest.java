package com.paypal.bfs.test.employeeserv.parser;

import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeParserTest {
    EmployeeParser employeeParser = new EmployeeParser();

    @Test
    void testToObject() {
        EmployeeTable result = employeeParser.toObject(new Employee());
        Assertions.assertEquals(new EmployeeTable(Long.valueOf(1), "first_name", "last_name", "date_of_birth", "address_line1", "address_line2", "city", "state", "country", "zip_code"), result);
    }

    @Test
    void testToJSON() {
        Employee result = employeeParser.toJSON(new EmployeeTable(Long.valueOf(1), "first_name", "last_name", "date_of_birth", "address_line1", "address_line2", "city", "state", "country", "zip_code"));
        Assertions.assertEquals(new Employee(), result);
    }
}
