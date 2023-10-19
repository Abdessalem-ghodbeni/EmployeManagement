package com.crud.employemanagement.Services.Impl;

import com.crud.employemanagement.Dto.EmployeeDto;
import com.crud.employemanagement.Entity.Employee;
import com.crud.employemanagement.Exceptions.RessourceNotFound;
import com.crud.employemanagement.Mapper.EmployeeMapper;
import com.crud.employemanagement.Repository.EmployeeRepository;
import com.crud.employemanagement.Services.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto GetEmployeeById(Long employeeId) {
       Employee employeeById= employeeRepository.findById(employeeId).orElseThrow(()-> new RessourceNotFound("Employée non trouvale avec l'id "+ employeeId));
       return EmployeeMapper.mapToEmployeeDto(employeeById);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees=employeeRepository.findAll();
      List<EmployeeDto> employeeDtoList=  employees.stream()
                .map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
      return employeeDtoList;
    }

    @Override
    public EmployeeDto UpdateEmploy(Long empId, EmployeeDto employeeDtoUpdating) {

        Employee employeeToUpdate=employeeRepository.findById(empId).orElseThrow(()->new RessourceNotFound("Employe n'existe pas avec cet id"+empId));
        employeeToUpdate.setFirstName(employeeDtoUpdating.getFirstName());
        employeeToUpdate.setLastName((employeeDtoUpdating.getLastName()));
        employeeToUpdate.setEmail(employeeDtoUpdating.getEmail());
        employeeRepository.save(employeeToUpdate);

        return EmployeeMapper.mapToEmployeeDto(employeeToUpdate);


    }

    @Override
    public void DeleteEmploye(Long idEmploye) {
        Employee employeToDeleted=employeeRepository.findById(idEmploye).orElseThrow(()->new RessourceNotFound("Employée introuvable avec l'id : "+idEmploye));
        employeeRepository.deleteById(idEmploye);

    }
}
