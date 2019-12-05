package org.github.athishsreeram.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
}