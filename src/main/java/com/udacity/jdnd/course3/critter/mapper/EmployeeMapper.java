package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {
    // Employee --> DTO
    public EmployeeDTO convertEmployeeToEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        return employeeDTO;
    }
    public List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(List<Employee> employeeList){
        return employeeList.stream().map(this::convertEmployeeToEmployeeDTO).collect(Collectors.toList());
    }

    //DTO --> Employee
    public Employee convertEmployeeDTOToEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        return employee;
    }
}
