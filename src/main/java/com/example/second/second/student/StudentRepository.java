package com.example.second.second.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<student, Long> {

    @Query("SELECT s FROM student s WHERE s.email = ?1")
    Optional<student> findStudentByEmail(String email);

    @Query("SELECT s FROM student s WHERE s.rollNumber = ?1")
    Optional<student> findStudentByRollNumber(String rollNumber);
}
