import domain.Student;
import service.StudentService;

public class StudentClient {
    protected StudentService studentService = new StudentServiceRemote();

    public static void main(String[] args) {
        new StudentClient().execute();
    }

    public void execute() {
        Student student = studentService.get();
        System.out.println(student.id);
        System.out.println(student.name);
        System.out.println(student.score);

        Integer value = studentService.post(student);
        System.out.println(value);
    }
}
