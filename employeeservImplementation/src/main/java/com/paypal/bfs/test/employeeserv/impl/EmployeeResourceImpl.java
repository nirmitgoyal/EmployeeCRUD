package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.employeeserv.api.EmployeeResource;
import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.errors.Errors;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.util.Validator;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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

    @Override
    public ResponseEntity<Employee> employeeGetById(Long id) {
        return employeeService
                .byId(id)
                .map(value -> new ResponseEntity<>(value, OK))
                .orElseGet(() -> new ResponseEntity<>(NOT_FOUND));
    }

    @Override
    public ResponseEntity createEmployee(Employee employee) {
        if (employee.getId() != null) {
            Optional<Employee> e = employeeService.byId(employee.getId());

            if (e.isPresent())
                return ResponseEntity
                        .status(FORBIDDEN)
                        .body("Employee already exists");
        }

        Optional<List<Errors>> error = validator.validate(employee);
        if (error.isPresent())
            return ResponseEntity
                    .status(BAD_REQUEST)
                    .body(error);

        return employeeService.create(employee)
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
