package com.paypal.bfs.employeeserv.api;

import com.paypal.bfs.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * The interface Employee resource.
 */
public interface EmployeeResource {

    /**
     * Employee get by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") Long id);

    /**
     * Create employee response entity.
     *
     * @param employee the employee
     * @return the response entity
     */
    @PostMapping(value = "/v1/bfs/employee", consumes = APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> createEmployee(@Valid @RequestBody final Employee employee);

}
