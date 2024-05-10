package com.mert.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_succesfully_save_a_student() {
        //Given
        StudentDto studentDto = new StudentDto(
                "Mert",
                "MURAT",
                "mert@gmail.com",
                1
        );

        Student student = new Student(
                "Mert",
                "MURAT",
                "mert@gmail.com",
                28
        );

        Student savedStudent = new Student(
                "Mert",
                "MURAT",
                "mert@gmail.com",
                28
        );
        savedStudent.setId(1);

        // Mock the calls
        when(studentMapper.toStudent(studentDto))
                .thenReturn(student);
        when(studentRepository.save(student))
                .thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto(
                        "Mert",
                        "MURAT",
                        "mert@gmail.com"));

        // When
        StudentResponseDto responseDto = studentService.saveStudent(studentDto);

        // Then
        assertEquals(studentDto.firstname(), responseDto.firstname());
        assertEquals(studentDto.lastname(), responseDto.lastname());
        assertEquals(studentDto.email(), responseDto.email());

        verify(studentMapper, times(1))
                .toStudent(studentDto);
        verify(studentRepository, times(1))
                .save(student);
        verify(studentMapper, times(1))
                .toStudentResponseDto(savedStudent);
    }

    @Test
    public void should_return_all_students(){
        // Given
         List<Student> students = new ArrayList<>();
         students.add(new Student(
                 "Mert",
                 "MURAT",
                 "mert@gmail.com",
                 28
         ));

         // Mock The Calls
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "Mert",
                        "MURAT",
                        "mert@gmail.com"));

        // When
        List<StudentResponseDto> responseDtos = studentService.findAllStudent();

        // Then
        assertEquals(students.size(), responseDtos.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void should_return_student_by_id(){
        // Given
        Integer studentId  = 1;
        Student student = new Student(
                "Mert",
                "MURAT",
                "mert@gmail.com",
                28
        );

        // Mock the calls
        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));

        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "Mert",
                        "MURAT",
                        "mert@gmail.com"));

        // When
        StudentResponseDto studentResponseDto = studentService.findStudentById(studentId);

        // Then
        assertEquals(studentResponseDto.firstname(), student.getFirstname());
        assertEquals(studentResponseDto.lastname(), student.getLastname());
        assertEquals(studentResponseDto.email(), student.getEmail());

        verify(studentRepository, times(1)).findById(studentId); 
    }

    @Test
    public void should_find_student_by_name(){
        // Given
        String studentName = "";
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "Mert",
                "MURAT",
                "mert@gmail.com",
                28
        ));

        // Mock The Calls
        when(studentRepository.findAllByFirstnameContaining(studentName))
                .thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "Mert",
                        "MURAT",
                        "mert@gmail.com"));

        // When

        var responseDto = studentService.findStudentByFirstname(studentName);

        // Then

        assertEquals(students.size(), responseDto.size());
        
        verify(studentRepository, times(1))
                .findAllByFirstnameContaining(studentName);
    }
}