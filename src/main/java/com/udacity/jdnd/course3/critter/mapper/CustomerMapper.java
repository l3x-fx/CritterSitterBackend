package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    //Customer --> DTO
    public CustomerDTO convertCustomerToCustomerDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }
    public List<CustomerDTO> convertCustomerListToCustomerDTOList(List<Customer> customerList){
        return customerList.stream().map(this::convertCustomerToCustomerDTO).collect(Collectors.toList());
    }

    //DTO --> Customer
    public Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }
}
