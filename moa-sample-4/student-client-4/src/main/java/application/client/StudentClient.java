package application.client;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import service.StudentService;

@Component
public class StudentClient {
    @Autowired(required = false)
    StudentService studentService;

    public void execute() {
        Student student = studentService.get();
        System.out.println(student.id);
        System.out.println(student.name);
        System.out.println(student.score);

        Integer value = studentService.post(student);
        System.out.println(value);
    }
}
