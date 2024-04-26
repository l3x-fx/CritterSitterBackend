package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.mapper.CustomerMapper;
import com.udacity.jdnd.course3.critter.mapper.EmployeeMapper;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;

    //CUSTOMER

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
         Customer customer = customerMapper.convertCustomerDTOToCustomer(customerDTO);
        Customer response = customerService.saveCustomer(customer);
        return customerMapper.convertCustomerToCustomerDTO(response);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers(){
        return customerMapper.convertCustomerListToCustomerDTOList(customerService.getAllCustomer());
    }

    @GetMapping("/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        return customerMapper.convertCustomerToCustomerDTO(customerService.getCustomerByPetId(petId));
    }
}
