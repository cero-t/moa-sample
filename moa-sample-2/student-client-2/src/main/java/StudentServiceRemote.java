import domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import service.StudentService;

public class StudentServiceRemote implements StudentService {
    @Override
    public Student get() {
        ResponseEntity<Student> result = new RestTemplate().getForEntity("http://localhost:8080/student", Student.class);
        return result.getBody();
    }

    @Override
    public int post(Student student) {
        return new RestTemplate().postForObject("http://localhost:8080/student", student, Integer.class);
    }
}
