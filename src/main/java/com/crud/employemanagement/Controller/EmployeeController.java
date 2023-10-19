package com.crud.employemanagement.Controller;

import com.crud.employemanagement.Dto.EmployeeDto;
import com.crud.employemanagement.Services.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
    EmployeeDto empDto=employeeServices.GetEmployeeById(employeeId);
    return   ResponseEntity.ok(empDto);
    }
@GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
    List<EmployeeDto> employeeDtos=employeeServices.getAllEmployee();
    return ResponseEntity.ok(employeeDtos);
    }

}
