package by.bryl.studenttracker.service.implementation;

import by.bryl.studenttracker.entity.Student;
import by.bryl.studenttracker.repository.IStudentDao;
import by.bryl.studenttracker.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link IStudentService} interface.
 *
 * @author Andrew Bryl
 */

@Service
public class StudentServiceImpl implements IStudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private IStudentDao studentDao;

    @Autowired
    public StudentServiceImpl(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public List<Student> getStudents() {
        LOGGER.info("Getting all students");
        List<Student> students = studentDao.getStudents();
        LOGGER.info("Students have been successfully gotten");
        return students;
    }

    @Override
    @Transactional
    public void save(Student student) {
        if(student.getId() == 0) {
            LOGGER.info("Trying to save student " + student);
        } else {
            LOGGER.info("Trying to update student to " + student);
        }
        studentDao.save(student);
        LOGGER.info("Student " + student + " has been successfully saved/updated");
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        LOGGER.info("Trying to delete student with id " + id);
        studentDao.deleteStudent(id);
        LOGGER.info("Student with id " + id + " has been successfully deleted");
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        LOGGER.info("Trying to get student with id " + id);
        Student student = studentDao.getStudentById(id);
        LOGGER.info("Got student " + student + " from a database");
        return student;
    }

    @Override
    @Transactional
    public List<Student> searchStudents(String name) {
        LOGGER.info("Trying to search students with first name or last name like " + name);
        List<Student> students;
        if (name != null && name.trim().length() > 0) {
            students = studentDao.searchStudents(name);
        } else {
            students = studentDao.getStudents();
        }
        LOGGER.info("Searching has been successfully ended. Students found: " + students.size());
        return students;
    }
}
