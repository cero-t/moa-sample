import domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import service.StudentService;

public class StudentClient {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceRemote();

        Student student = studentService.get();
        System.out.println(student.id);
        System.out.println(student.name);
        System.out.println(student.score);

        Integer value = studentService.post(student);
        System.out.println(value);
    }
}
