package com.belymenko.employee.controller;

import com.belymenko.employee.model.Employee;
import com.belymenko.employee.producer.EmployeeProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeProducer employeeProducer;

    @PostMapping("/employees/{id}/{firstName}/{lastName}")
    public ResponseEntity<Void> produceMessage(@PathVariable long id,
                                               @PathVariable String firstName,
                                               @PathVariable String lastName) {
        employeeProducer.produce(Employee.builder().id(id).firstName(firstName).lastName(lastName).build());
        return ResponseEntity.ok().build();
    }
}