package org.github.athishsreeram.project;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Project {

    @Id
    private String project_id;

    private String project_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_project_id")
    private Project parent;

    private Date project_start_date;

    @CreationTimestamp
    private Date created_date;


}