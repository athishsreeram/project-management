package org.github.athishsreeram.employee;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long employee_id;

    private String employee_first_name;

    private String employee_last_name;

    private String manager_id;


}