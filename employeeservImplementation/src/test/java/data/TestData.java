package data;

import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeTable;

public class TestData {
    public static final Employee TEST_EMPLOYEE = new Employee()
            .withId(1l)
            .withFirstName("Nirmit")
            .withLastName("Goyal")
            .withDateOfBirth("01-12-1995")
            .withAddressLine1("L1008")
            .withAddressLine2("Brigade")
            .withCity("Bangalore")
            .withState("KA")
            .withZipCode("India")
            .withCountry("560055");
    public static final Employee INVALID_TEST_EMPLOYEE = new Employee()
            .withId(1l)
            .withFirstName("Nirmit")
            .withLastName("Goyal")
            .withAddressLine1("L1008")
            .withAddressLine2("Brigade")
            .withCity("Bangalore")
            .withState("KA")
            .withZipCode("India")
            .withCountry("560055");

    public static final EmployeeTable TEST_EMPLOYEE_TABLE = EmployeeTable.builder()
            .id(1l)
            .first_name("Nirmit")
            .last_name("Goyal")
            .date_of_birth("01-12-1995")
            .address_line1("L1008")
            .address_line2("Brigade")
            .city("Bangalore")
            .state("KA")
            .zip_code("India")
            .country("560055")
            .build();
}
