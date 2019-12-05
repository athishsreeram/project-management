package org.github.athishsreeram.team;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.github.athishsreeram.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/team")
@Slf4j
@RequiredArgsConstructor
public class TeamAPI {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamDTO>> findAll() {
        return ResponseEntity.ok(teamService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody TeamDTO team) throws ResourceNotFoundException {


        return ResponseEntity.ok(teamService.save(team));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> findById(@PathVariable String id) {
        Optional<TeamDTO> stock = teamService.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> update(@PathVariable String id, @Valid @RequestBody TeamDTO team) throws ResourceNotFoundException {
        if (!teamService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(teamService.save(team).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        if (!teamService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        teamService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}