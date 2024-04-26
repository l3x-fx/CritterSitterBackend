package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    private final PetRepository petRepository;

    public CustomerMapper(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    //Customer --> DTO
    public CustomerDTO convertCustomerToCustomerDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        if(customer.getPets() != null){
            customerDTO.setPetIds(customer.getPets().stream().map(Pet::getId).collect(Collectors.toList()));
        }
        return customerDTO;
    }
    public List<CustomerDTO> convertCustomerListToCustomerDTOList(List<Customer> customerList){
        return customerList.stream().map(this::convertCustomerToCustomerDTO).collect(Collectors.toList());
    }

    //DTO --> Customer
    public Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        if(customerDTO.getPetIds() != null){
            customer.setPets(petRepository.findAllById(customerDTO.getPetIds()));
        }
        return customer;
    }
}
