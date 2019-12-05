package org.github.athishsreeram.employee;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeAPI {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody EmployeeDTO product) {
        return ResponseEntity.ok(employeeService.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        Optional<EmployeeDTO> stock = employeeService.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @GetMapping("/managers/all")
    public ResponseEntity<List<EmployeeDTO>> findAllManagers() {
        return ResponseEntity.ok(employeeService.findAllManagers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @Valid @RequestBody EmployeeDTO product) {
        if (!employeeService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(employeeService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!employeeService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        employeeService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}