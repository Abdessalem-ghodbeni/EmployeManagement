package com.crud.employemanagement.Services;

import com.crud.employemanagement.Dto.EmployeeDto;

import java.util.List;

public interface EmployeeServices {
    EmployeeDto creatEmployee(EmployeeDto employeeDto);
    EmployeeDto GetEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto UpdateEmploy(Long empId,EmployeeDto employeeDtoUpdating);
    void DeleteEmploye(Long idEmploye);
}
