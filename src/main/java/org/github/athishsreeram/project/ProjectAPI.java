package org.github.athishsreeram.project;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/project")
@Slf4j
@RequiredArgsConstructor
public class ProjectAPI {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> findAll() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ProjectDTO product) {
        return ResponseEntity.ok(projectService.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> findById(@PathVariable String id) {
        Optional<ProjectDTO> stock = projectService.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(@PathVariable String id, @Valid @RequestBody ProjectDTO product) {
        if (!projectService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(projectService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        if (!projectService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        projectService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}