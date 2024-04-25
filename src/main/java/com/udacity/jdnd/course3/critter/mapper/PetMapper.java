package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetMapper {
    // Pet --> DTO
    public PetDTO convertPetToPetDTO(Pet pet){
        PetDTO petDTO = new PetDTO();
        BeanUtils.copyProperties(pet, petDTO);
        petDTO.setOwnerId(pet.getCustomer().getId());
        petDTO.setBirthDate(convertToLocalDate(pet.getBirthDate()));
        return petDTO;
    }
    public List<PetDTO> convertPetListToPetDTOList(List<Pet> petList){
        return petList.stream().map(this::convertPetToPetDTO).collect(Collectors.toList());
    }

    //DTO --> Pet
    public Pet convertPetDTOToPet(PetDTO petDTO){
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);
        Customer customer = new Customer();
        customer.setId(petDTO.getOwnerId());
        pet.setCustomer(customer);
        pet.setBirthDate(convertToDate(petDTO.getBirthDate()));
        return pet;
    }

    private static LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private static Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
}
