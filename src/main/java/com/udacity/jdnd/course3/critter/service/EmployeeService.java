package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Optional getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Long saveEmployee(Employee employee) {
       return employeeRepository.save(employee).getId();

    }
    public Long setEmployeeAvailability(Set<DayOfWeek> days, Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        if (employee != null) {
            employee.setDaysAvailable(days);
            return employeeRepository.save(employee).getId();
        }
        return null;
    }

    public List<Employee> findEmployeesForService(EmployeeRequestDTO request) {
        DayOfWeek date = request.getDate().getDayOfWeek();
        Set<EmployeeSkill> skills = request.getSkills();
        List<Employee> availableEmployees = employeeRepository.findByDaysAvailable(request.getDate())
    }
    //findEmployeesForService
}
