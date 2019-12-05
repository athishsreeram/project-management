package org.github.athishsreeram.project;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Project {

    @Id
    private String project_id;

    private String project_name;

    private String parent_project_id;

    private Date project_start_date;

    @CreationTimestamp
    private Date created_date;


}