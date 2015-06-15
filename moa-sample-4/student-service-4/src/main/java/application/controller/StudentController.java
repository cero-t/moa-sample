package application.controller;

import domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.StudentService;

@RestController
public class StudentController implements StudentService {
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    @Override
    public Student get() {
        Student student = new Student();
        student.id = 1;
        student.name = "TEST";
        student.score = 100;
        return student;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    @Override
    public int post(Student student) {
        return 1;
    }
}
