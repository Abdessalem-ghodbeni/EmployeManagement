package com.crud.employemanagement.Controller;

import com.crud.employemanagement.Dto.EmployeeDto;
import com.crud.employemanagement.Services.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeServices employeeServices;
@PostMapping
    public ResponseEntity<EmployeeDto> createEmployes(@RequestBody  EmployeeDto employeeDto)
    {
        EmployeeDto employeSaved=employeeServices.creatEmployee(employeeDto);
        return new ResponseEntity<>(employeSaved, HttpStatus.CREATED);
    }
}
