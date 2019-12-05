package org.github.athishsreeram.project;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {

    private String project_id;

    private String project_name;

    private String parent_project_id;

    private Date project_start_date;


}