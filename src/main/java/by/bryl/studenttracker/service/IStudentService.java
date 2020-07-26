package by.bryl.studenttracker.service;

import by.bryl.studenttracker.entity.Student;

import java.util.List;

/**
 * Service class for {@link Student}
 *
 * @author Andrew Bryl
 */

public interface IStudentService {
    List<Student> getStudents();

    void save(Student student);

    void deleteStudent(int id);

    Student getStudentById(int id);
}
