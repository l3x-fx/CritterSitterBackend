package com.udacity.jdnd.course3.critter.service;


import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    public Long setEmployeeAvailability(Set<DayOfWeek> days, Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
            employee.setDaysAvailable(days);
        return employeeRepository.save(employee).getId();
    }

    public List<Employee> findEmployeesForService(EmployeeRequestDTO request) {
        DayOfWeek date = request.getDate().getDayOfWeek();
        Set<EmployeeSkill> skills = request.getSkills();

        List<Employee> availableEmp = employeeRepository.findByDaysAvailable(date);
        return availableEmp.stream().filter(employee -> employee.getSkills().containsAll(skills)).collect(Collectors.toList());
    }

}
