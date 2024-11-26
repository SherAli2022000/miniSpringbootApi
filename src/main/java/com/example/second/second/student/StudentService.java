package com.example.second.second.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(student s) {
        // Check if email already exists
        Optional<student> optionalStudentByEmail = studentRepository.findStudentByEmail(s.getEmail());
        if (optionalStudentByEmail.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }

        // Check if roll number already exists
        Optional<student> optionalStudentByRollNumber = studentRepository.findStudentByRollNumber(s.getRollNumber());
        if (optionalStudentByRollNumber.isPresent()) {
            throw new IllegalStateException("Roll number already taken");
        }

        studentRepository.save(s);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with ID does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email, String rollNumber) {
        student student1 = studentRepository.findById(studentId).orElseThrow(() ->
                new IllegalStateException("Student with this ID does not exist")
        );

        if (name != null && !name.trim().isEmpty() && !name.equals(student1.getName())) {
            student1.setName(name);
        }

        if (email != null && !email.trim().isEmpty()) {
            Optional<student> studentExists = studentRepository.findStudentByEmail(email);
            if (studentExists.isPresent()) {
                throw new IllegalStateException("Email already taken");
            }
            student1.setEmail(email);
        }

        if (rollNumber != null && !rollNumber.trim().isEmpty()) {
            Optional<student> rollNumberExists = studentRepository.findStudentByRollNumber(rollNumber);
            if (rollNumberExists.isPresent()) {
                throw new IllegalStateException("Roll number already taken");
            }
            System.out.println("this here");
            student1.setRollNumber(rollNumber);
        }
    }
}
