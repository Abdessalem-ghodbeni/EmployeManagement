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

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> UpdateEmpoyee(@PathVariable("id") Long idEmployee,@RequestBody EmployeeDto employeeDtoUpdatinng){

    EmployeeDto employeeDtoUpdated=employeeServices.UpdateEmploy(idEmployee,employeeDtoUpdatinng);
    return ResponseEntity.ok(employeeDtoUpdated);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String > DeleteEmploy(@PathVariable("id") Long idEmployee){
    employeeServices.DeleteEmploye(idEmployee);
    return ResponseEntity.ok("Employe deleted Successfuly");
    }
}
