package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.mapper.CustomerMapper;
import com.udacity.jdnd.course3.critter.mapper.EmployeeMapper;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;


    @PostMapping
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.convertEmployeeDTOToEmployee(employeeDTO);
        Employee response = employeeService.saveEmployee(employee);
        return employeeMapper.convertEmployeeToEmployeeDTO(response);
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        return employeeMapper.convertEmployeeToEmployeeDTO(employeeService.getEmployeeById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found!"))
        );
    }

    @PutMapping("/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        employeeService.setEmployeeAvailability(daysAvailable, employeeId);
    }

    @GetMapping("/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        return employeeMapper.convertEmployeeListToEmployeeDTOList(employeeService.findEmployeesForService(employeeDTO));

    }

}
