package com.paypal.bfs.test.employeeserv.parser;


import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeTable;
import org.springframework.stereotype.Component;

/**
 * The type Employee parser.
 */
@Component
public class EmployeeParser {

    /**
     * To object employee table.
     *
     * @param employee the employee
     * @return the employee table
     */
    public EmployeeTable toObject(Employee employee) {
        return EmployeeTable.builder()
                .first_name(employee.getFirstName())
                .last_name(employee.getLastName())
                .date_of_birth(employee.getDateOfBirth())
                .address_line1(employee.getAddressLine1())
                .address_line2(employee.getAddressLine2())
                .city(employee.getCity())
                .state(employee.getState())
                .zip_code(employee.getZipCode())
                .country(employee.getCountry())
                .build();
    }

    /**
     * To json employee.
     *
     * @param employeeTable the employee table
     * @return the employee
     */
    public Employee toJSON(EmployeeTable employeeTable) {
        return new Employee()
                .withFirstName(employeeTable.getFirst_name())
                .withLastName(employeeTable.getLast_name())
                .withDateOfBirth(employeeTable.getDate_of_birth())
                .withAddressLine1(employeeTable.getAddress_line1())
                .withAddressLine2(employeeTable.getAddress_line2())
                .withCity(employeeTable.getCity())
                .withState(employeeTable.getState())
                .withZipCode(employeeTable.getZip_code())
                .withCountry(employeeTable.getCountry());
    }

}
