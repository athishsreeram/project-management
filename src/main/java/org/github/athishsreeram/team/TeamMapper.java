package org.github.athishsreeram.team;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    @Mappings({
            @Mapping(source = "project.project_id",target = "project_id"),
            @Mapping(source = "employee.employee_id",target = "employee_id")
        }
    )
    TeamDTO TeamToTeamDTO(Team Team);

    List<TeamDTO> TeamsToTeamsDto(List<Team> Team);

    @InheritInverseConfiguration
    Team TeamDTOToTeamDomain(TeamDTO Team);

}