package org.github.athishsreeram.employee;

import lombok.Data;
import org.github.athishsreeram.team.Team;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Employee {

    @Id
    private Long employee_id;

    private String employee_first_name;

    private String employee_last_name;

    private String manager_id;

    @CreationTimestamp
    private Date created_date;


}