package org.github.athishsreeram.team;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TeamDTO {

    @NotNull(message = "Please provide Project Id")
    private String project_id;

    @NotNull(message = "Please provide Team Id")
    private String team_id;

    @NotNull(message = "Please provide Team Name")
    private String team_name;

    @NotNull(message = "Please provide Employee Id")
    private Long employee_id;


}