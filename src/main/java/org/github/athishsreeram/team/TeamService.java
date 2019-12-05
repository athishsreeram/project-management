package org.github.athishsreeram.team;

import lombok.RequiredArgsConstructor;
import org.github.athishsreeram.employee.Employee;
import org.github.athishsreeram.employee.EmployeeRespository;
import org.github.athishsreeram.employee.EmployeeService;
import org.github.athishsreeram.exception.ResourceNotFoundException;
import org.github.athishsreeram.project.Project;
import org.github.athishsreeram.project.ProjectRespository;
import org.github.athishsreeram.project.ProjectService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TeamService {


    private final TeamRespository teamRespository;
    private final TeamMapper teamMapper;

    private final EmployeeRespository employeeRespository;
    private final ProjectRespository projectRespository;



    public List<TeamDTO> findAll() {
        List<Team> lstPjt =  teamRespository.findAll();

        if(!lstPjt.isEmpty()) {
            return teamMapper.TeamsToTeamsDto(lstPjt);
        }

        return new ArrayList<TeamDTO>();

    }

    public Optional<TeamDTO> findById(String id) {

        Optional<Team> pjt = teamRespository.findById(id);

        if(pjt.isPresent()) {
            return Optional.of(teamMapper.TeamToTeamDTO(pjt.get()));
        }

        return Optional.empty();
    }

    public Optional<TeamDTO> save(TeamDTO teamDTO) throws ResourceNotFoundException {

        Team team = teamMapper.TeamDTOToTeamDomain(teamDTO);

        Optional<Employee> emp = employeeRespository.findById(teamDTO.getEmployee_id());
        Optional<Project> pjt = projectRespository.findById(teamDTO.getProject_id());

        if(pjt.isPresent())
             team.setProject(pjt.get());
        else
           throw new ResourceNotFoundException("Project id not found");

        if(emp.isPresent())
            team.setEmployee(emp.get());
        else
           throw new ResourceNotFoundException("Employee id not found");


        team = teamRespository.save(team);

        return findById(team.getTeam_id());

    }

    public void deleteById(String id) {

        Team team = teamRespository.findById(id).get();


        teamRespository.delete(team);
    }
}