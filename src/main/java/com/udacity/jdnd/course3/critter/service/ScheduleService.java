package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getByPetId(long petId) {
        return scheduleRepository.findByPets_Id(petId);
    }

    public List<Schedule> getByEmployeeId(long employeeId) {
        return scheduleRepository.findByEmployees_Id(employeeId);
    }

    public List<Schedule> getByCustomerId(long customerId) {
        return scheduleRepository.findByPets_Customer_Id(customerId);
    }
}
