package by.bryl.studenttracker.repository;

import by.bryl.studenttracker.entity.Student;

import java.util.List;

/**
 * Repository class for {@link Student}
 *
 * @author Andrew Bryl
 */

public interface IStudentDao {
    List<Student> getStudents();

    void save(Student student);

    void deleteStudent(int id);

    Student getStudentById(int id);
}
