package service;

import domain.Student;

public interface StudentService {
    Student get();
    int post(Student student);
}
