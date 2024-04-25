package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public Pet save(Pet pet) {
        return petRepository.save(pet);
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
