package com.crud.employemanagement.Services.Impl;

import com.crud.employemanagement.Dto.EmployeeDto;
import com.crud.employemanagement.Entity.Employee;
import com.crud.employemanagement.Mapper.EmployeeMapper;
import com.crud.employemanagement.Repository.EmployeeRepository;
import com.crud.employemanagement.Services.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeServices {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto creatEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);//c'est pour convertir employeeDto en Employee et le stocker dans la variable employee de type Employee comme l'entité car nous allons le stocker dans la basse de donner
       Employee employeeSaved= employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(employeeSaved);
    }
}
