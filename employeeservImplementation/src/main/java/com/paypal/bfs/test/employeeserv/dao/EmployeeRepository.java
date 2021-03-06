package com.paypal.bfs.test.employeeserv.dao;

import com.paypal.bfs.test.employeeserv.model.EmployeeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Employee repository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTable, Long> {
}
