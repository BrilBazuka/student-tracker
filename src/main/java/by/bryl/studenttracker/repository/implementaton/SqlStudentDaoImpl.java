package by.bryl.studenttracker.repository.implementaton;

import by.bryl.studenttracker.entity.Student;
import by.bryl.studenttracker.repository.IStudentDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link IStudentDao} interface.
 *
 * @author Andrew Bryl
 */

@Repository
public class SqlStudentDaoImpl implements IStudentDao {

    private EntityManager entityManager;

    @Autowired
    public SqlStudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getStudents() {
        Session session = entityManager.unwrap(Session.class);

        Query<Student> getStudentsQuery = session.createQuery("from Student", Student.class);

        return getStudentsQuery.getResultList();
    }

    @Override
    public void save(Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);
    }

    @Override
    public void deleteStudent(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query<Student> deleteStudentQuery = session.createQuery("delete from Student where id =: id");
        deleteStudentQuery.setParameter("id", id);

        deleteStudentQuery.executeUpdate();
    }

    @Override
    public Student getStudentById(int id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Student.class, id);
    }

    @Override
    public List<Student> searchStudents(String name) {
        Session session = entityManager.unwrap(Session.class);
        Query<Student> query = session.createQuery("from Student where lower(firstName) like :name or lower(lastName) like :name", Student.class);
        query.setParameter("name", "%" + name.toLowerCase() + "%");
        return query.getResultList();
    }
}
