package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.mapper.PetMapper;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetMapper petMapper;
    @Autowired
    PetService petService;


    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = petMapper.convertPetDTOToPet(petDTO);
        Pet response = petService.save(pet);
        return petMapper.convertPetToPetDTO(response);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return petMapper.convertPetToPetDTO(petService.getById(petId));
    }

    @GetMapping
    public List<PetDTO> getPets(){
        return petMapper.convertPetListToPetDTOList(petService.getAll());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        return petMapper.convertPetListToPetDTOList(petService.getByCustomerId(ownerId));
    }
}
