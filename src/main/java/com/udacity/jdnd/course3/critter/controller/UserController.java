package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.mapper.CustomerMapper;
import com.udacity.jdnd.course3.critter.mapper.EmployeeMapper;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    EmployeeService employeeService;
//    @Autowired
//    CustomerService customerService;
//
//    @Autowired
//    EmployeeMapper employeeMapper;
//
//    @Autowired
//    CustomerMapper customerMapper;
//
//    //CUSTOMER
//
//    @PostMapping("/customer")
//    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping("/customer")
//    public List<CustomerDTO> getAllCustomers(){
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping("/customer/pet/{petId}")
//    public CustomerDTO getOwnerByPet(@PathVariable long petId){
//        throw new UnsupportedOperationException();
//    }
//
//
//    //EMPLOYEE
//
//
//    @PostMapping("/employee")
//    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        Employee employee = employeeMapper.convertEmployeeDTOToEmployee(employeeDTO);
//        Employee response = employeeService.saveEmployee(employee);
//        return employeeMapper.convertEmployeeToEmployeeDTO(response);
//    }
//
//    @PostMapping("/employee/{employeeId}")
//    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
//        throw new UnsupportedOperationException();
//    }
//
//    @PutMapping("/employee/{employeeId}")
//    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
//        throw new UnsupportedOperationException();
//    }
//
//    @GetMapping("/employee/availability")
//    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
//        throw new UnsupportedOperationException();
//    }

}
