package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "employee_skills", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "skills")
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> skills = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "employee_days_available", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "days_available")
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> daysAvailable;

}
