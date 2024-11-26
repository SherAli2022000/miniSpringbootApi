package com.example.second.second.student;

import java.time.LocalDate;
public class StudentDTO {
    private Long id;
    private String rollNumber;
    private String name;
    private int age;
    private String email;
    private LocalDate dob;
    private String departmentName;

    public StudentDTO(student student) {
        this.id = student.getId();
        this.rollNumber = student.getRollNumber();
        this.name = student.getName();
        this.age = student.getAge();
        this.email = student.getEmail();
        this.dob = student.getDob();
        this.departmentName = student.getDepartment().getName();
    }

    // Add getters for all fields
    public Long getId() {
        return id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

