package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleMapper {
    @Autowired
    PetRepository petRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    // Schedule --> DTO
    public ScheduleDTO convertScheduleToScheduleDTO(Schedule schedule){
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        BeanUtils.copyProperties(schedule, scheduleDTO);
        scheduleDTO.setEmployeeIds(schedule.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()));
        scheduleDTO.setPetIds(schedule.getPets().stream().map(Pet::getId).collect(Collectors.toList()));
        return scheduleDTO;
    }
    public List<ScheduleDTO> convertScheduleListToScheduleDTOList(List<Schedule> scheduleList){
        return scheduleList.stream().map(this::convertScheduleToScheduleDTO).collect(Collectors.toList());
    }

    //DTO --> Schedule
    public Schedule convertScheduleDTOToSchedule(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        schedule.setPets(petRepository.findAllById(scheduleDTO.getPetIds()));
        schedule.setEmployees(employeeRepository.findAllById(scheduleDTO.getEmployeeIds()));
        return schedule;
    }
}
