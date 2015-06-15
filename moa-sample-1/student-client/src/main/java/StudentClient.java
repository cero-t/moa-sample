import domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StudentClient {
    public static void main(String[] args) {
        ResponseEntity<Student> result = new RestTemplate().getForEntity("http://localhost:8080/student", Student.class);
        Student body = result.getBody();
        System.out.println(body.id);
        System.out.println(body.name);
        System.out.println(body.score);
    }
}
