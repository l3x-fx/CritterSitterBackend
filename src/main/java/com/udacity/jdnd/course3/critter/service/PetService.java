package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;



    public Pet save(Pet pet) {
        Customer customer = customerRepository.findById(pet.getCustomer().getId()).orElseThrow(() -> new EntityNotFoundException("Customer not found!"));
        List<Pet> petList = customer.getPets();
        Pet savedPet = petRepository.save(pet);
        petList.add(savedPet);
        customer.setPets(petList);
        customerRepository.save(customer);
        return savedPet;
    }

    public Pet getById(long petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found!"));
    }
    public List<Pet> getAll() {
        return petRepository.findAll();
    }
    public List<Pet> getByCustomerId(long ownerId) {
        return petRepository.findByCustomer_Id(ownerId);
    }






}
