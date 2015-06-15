import domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StudentClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Student> result = restTemplate.getForEntity("http://localhost:8080/student", Student.class);
        Student student = result.getBody();
        System.out.println(student.id);
        System.out.println(student.name);
        System.out.println(student.score);

        Integer value = restTemplate.postForObject("http://localhost:8080/student", student, Integer.class);
        System.out.println(value);
    }
}
