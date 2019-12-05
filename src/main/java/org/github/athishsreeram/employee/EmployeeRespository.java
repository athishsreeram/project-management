package org.github.athishsreeram.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {

    @Query("SELECT u FROM Employee u WHERE u.employee_id in ( SELECT DISTINCT (e.manager_id) from Employee e WHERE e.manager_id != null )")
    List<Employee> findAllManagers();
}