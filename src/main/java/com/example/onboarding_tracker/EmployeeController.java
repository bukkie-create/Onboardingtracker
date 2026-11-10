
package com.example.onboarding_tracker;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
private final EmployeeRepository employeeRepository;

public EmployeeController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
}
@GetMapping
public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
}
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Employee createEmployee(@Valid @RequestBody Employee employee) {
    return employeeRepository.save(employee);
}

}
