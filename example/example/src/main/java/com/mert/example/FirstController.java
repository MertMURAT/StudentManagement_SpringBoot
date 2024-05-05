package com.mert.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController { 

    private final StudentRepository studentRepository;

    public FirstController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }


    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id") int id
    ){
        return studentRepository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/students/search/{student-firstname}")
    public List<Student> findStudentByFirstname(
            @PathVariable("student-firstname") String firstname
    ){
        return studentRepository.findAllByFirstnameContaining(firstname);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("student-id") Integer id
    ){
        studentRepository.deleteById(id);
    }
}
