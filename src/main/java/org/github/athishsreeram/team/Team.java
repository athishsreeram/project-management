package org.github.athishsreeram.team;

import lombok.Data;
import org.github.athishsreeram.employee.Employee;
import org.github.athishsreeram.project.Project;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Team {

    @Id
    private String team_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    private String team_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @CreationTimestamp
    private Date created_date;


}