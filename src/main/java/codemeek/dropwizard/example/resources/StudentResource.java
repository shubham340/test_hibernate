package codemeek.dropwizard.example.resources;

import codemeek.dropwizard.example.dao.StudentDao;
import codemeek.dropwizard.example.models.Student;
import codemeek.dropwizard.example.models.dto.StudentDTO;
import io.dropwizard.hibernate.UnitOfWork;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {
    private StudentDao studentDao;
    public StudentResource(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    private ModelMapper modelMapper;
    private StudentDTO convertToDto(Object student) {
        StudentDTO studentDto = modelMapper.map(student, StudentDTO.class);
        return studentDto;
    }
    private Student convertfromDto(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        return student;
    }

    @GET
    @Path("/student")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Student> findByEmailId(
            @QueryParam("name") Optional<String> emailId
    ) {
        List <Student> students;
        if (emailId.isPresent()) {
            students = studentDao.findByEmailId(emailId.get());
        } else {
            students = studentDao.findAll();
        }
        return students;
        //return students.stream(student->convertToDto(student)).collect(Collectors.toList());
    }


    @GET
    @Path("/student/{id}")
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Student> findById(@PathParam("id") String studentId) {
        //System.out.println(studentId);
        Optional<Student> student1;
        student1 = studentDao.findById(studentId);
        return student1;
//        StudentDTO studentDTO = modelMapper.map(student1,StudentDTO.class);
//        return studentDTO;
    }

    @Path("/student/insert")
    @POST
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public Student insertStudent(StudentDTO studentDTO){
        Student student = convertfromDto(studentDTO);
        Student student1 = studentDao.insertStudent(student);
        return student1;
    }

    @Path("/student/update/{id}")
    @PUT
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudent(@Valid Student student,@PathParam("id") String studentId){
        Student student1 = studentDao.updateStudent(student,studentId);
        return student1;
    }

    @Path("/student/delete/{id}")
    @DELETE
    @UnitOfWork
    public void deleteStudent(@PathParam("id") String studentId) {
        studentDao.deleteById(studentId);
    }

}
