package by.bryl.studenttracker.service.implementation;

import by.bryl.studenttracker.entity.Student;
import by.bryl.studenttracker.repository.IStudentDao;
import by.bryl.studenttracker.service.IStudentService;
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

    private IStudentDao studentDao;

    @Autowired
    public StudentServiceImpl(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    @Transactional
    public List<Student> searchStudents(String name) {
        List<Student> students;
        if (name != null && name.trim().length() > 0) {
            students = studentDao.searchStudents(name);
        } else {
            students = studentDao.getStudents();
        }
        return students;
    }
}
