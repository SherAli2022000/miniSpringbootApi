package com.example.second.second.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class student {
    @Id
    @SequenceGenerator(
            name = "sequence_name",
            sequenceName = "sequence_name",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_name")
    private long id;

    @Column(nullable = false, unique = true)
    private String rollNumber;

    private String name;

    @Transient
    private int age;

    private String email;

    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public student() {
    }

    public student(String rollNumber, String name, String email, LocalDate dob, Department department) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.department = department;
    }

    public student(long id, String rollNumber, String name, int age, String email, LocalDate dob, Department department) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
        this.department = department;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", department=" +department +
                '}';
    }
}
