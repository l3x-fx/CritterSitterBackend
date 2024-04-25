package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.mapper.ScheduleMapper;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    ScheduleMapper scheduleMapper;
    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleMapper.convertScheduleDTOToSchedule(scheduleDTO);
        return scheduleMapper.convertScheduleToScheduleDTO(scheduleService.save(schedule));
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleMapper.convertScheduleListToScheduleDTOList(scheduleService.getAll());
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        return scheduleMapper.convertScheduleListToScheduleDTOList(scheduleService.getByPetId(petId));
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        return scheduleMapper.convertScheduleListToScheduleDTOList(scheduleService.getByEmployeeId(employeeId));
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        return scheduleMapper.convertScheduleListToScheduleDTOList(scheduleService.getByCustomerId(customerId));
    }
}
