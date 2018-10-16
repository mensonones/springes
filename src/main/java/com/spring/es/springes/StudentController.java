package com.spring.es.springes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/")
    public String welcomeES() {
        return "Welcome to Spring Boot Elastic Search Example";
    }

    @GetMapping("/getAll")
    public List<Student> getAllAluns() {
        List<Student> students = new ArrayList<>();
        for (Student student : this.StudentRepository.findAll()) {
            students.add(student);
        }
        return Students;
    }

    @PostMapping("/save")
    public String saveAllStudents() {
        StudentRepository.saveAll(Arrays.asList(
                new Student("1", "Student1","Student1@mail.com", 20),
                new Student("2", "Student2","Student2@mail.com", 19),
                new Student("3", "Student3","Student3@mail.com", 18),
                new Student("4", "Student4","Student4@mail.com", 17)));
        return "students successfully saved...";

}

    @DeleteMapping("/delete")
    public String deleteAllStudents() {
        try {
            studentRepository.deleteAll();
            return "students successfully removed!";
        }catch (Exception e){
            return "Failed to delete students";
        }
    }
}
