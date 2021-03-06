package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.parser.EmployeeParser;
import com.paypal.bfs.test.employeeserv.model.EmployeeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Employee service.
 */
@Service
public class EmployeeService {
    /**
     * The Employee repository.
     */
    @Autowired
    private final EmployeeRepository employeeRepository;
    /**
     * The Employee parser.
     */
    @Autowired
    private final EmployeeParser employeeParser;

    /**
     * Instantiates a new Employee service.
     *
     * @param employeeRepository the employee repository
     * @param employeeParser     the employee parser
     */
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeParser employeeParser) {
        this.employeeRepository = employeeRepository;
        this.employeeParser = employeeParser;
    }

    /**
     * By id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Employee> byId(Long id) {
        Optional<EmployeeTable> employeeTable = employeeRepository.findById(id);

        if (employeeTable.isPresent()) {
            Employee employee = employeeParser.toJSON(employeeTable.get());
            return Optional.of(employee);
        }

        return Optional.empty();
    }

    /**
     * Create boolean.
     *
     * @param employeeRequest the employee request
     * @return the boolean
     */
    public boolean create(Employee employeeRequest) {
        try {
            employeeRepository.save(employeeParser.toObject(employeeRequest));
            return true;
        } catch (Exception e) {
            System.out.println("Exception in create table service");
        }

        return false;
    }

}
