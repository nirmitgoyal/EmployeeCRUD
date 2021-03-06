package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.employeeserv.api.EmployeeResource;
import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.errors.Errors;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

/**
 * The type Employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    /**
     * The Employee service.
     */
    @Autowired
    private final EmployeeService employeeService;

    /**
     * The Validator.
     */
    @Autowired
    private final Validator validator;

    /**
     * Instantiates a new Employee resource.
     *
     * @param employeeService the employee service
     * @param validator       the validator
     */
    private EmployeeResourceImpl(EmployeeService employeeService, Validator validator) {
        this.employeeService = employeeService;
        this.validator = validator;
    }

    @Override
    public ResponseEntity<Employee> employeeGetById(Long id) {
        return employeeService
                .byId(id)
                .map(value -> new ResponseEntity<>(value, OK))
                .orElseGet(() -> new ResponseEntity<>(NOT_FOUND));
    }

    @Override
    public ResponseEntity createEmployee(Employee employeeRequest) {
        if (employeeRequest.getId() != null) {
            Optional<Employee> employee = employeeService.byId(employeeRequest.getId());

            if (employee.isPresent())
                return ResponseEntity
                        .status(FORBIDDEN)
                        .body("Employee already exists");
        }

        Optional<List<Errors>> error = validator.validate(employeeRequest);
        if (error.isPresent())
            return ResponseEntity
                    .status(BAD_REQUEST)
                    .body(error);

        return employeeService.create(employeeRequest)
                ?
                ResponseEntity
                        .status(CREATED)
                        .body("Employee created")
                :
                ResponseEntity
                        .status(INTERNAL_SERVER_ERROR)
                        .body("Internal Server Error");
    }
}
