package codemeek.dropwizard.example.dao;
import codemeek.dropwizard.example.models.Student;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class StudentDao extends AbstractDAO<Student> {

    public StudentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Student> findAll(){
        return list(namedQuery("dropwizard.models.student.findAll"));
    }

    public List<Student> findByEmailId(String emailId){
        StringBuilder builder = new StringBuilder("%");
        builder.append(emailId).append("%");
        return list(namedQuery("dropwizard.models.student.findByEmailId")
                        .setParameter("emailId",builder.toString()));
    }
    public Optional<Student> findById(String id){
        /*StringBuilder builder = new StringBuilder("%");
        builder.append(id).append("%");*/
        return Optional.ofNullable(get(id));
        //return (Optional<Student>) list(namedQuery("dropwizard.models.student.findById").setParameter("studentId",id)).get(0);
    }
    public Student insertStudent(Student student){
        return persist(student);
    }

    public void deleteById(String studentID){
        Student student = new Student();
        student.setStudentId(studentID);
        currentSession().delete(student);
        //namedQuery("dropwizard.models.delete.student");
    }

    public Student updateStudent(Student student, String studentId){
        deleteById(studentId);
        return persist(student);
    }




}
