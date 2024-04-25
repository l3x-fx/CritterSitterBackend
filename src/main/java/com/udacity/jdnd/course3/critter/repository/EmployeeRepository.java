package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query("select e from Employee e where :dayOfWeek MEMBER OF e.daysAvailable")
    List<Employee> findByDaysAvailable(DayOfWeek dayOfWeek);
}
