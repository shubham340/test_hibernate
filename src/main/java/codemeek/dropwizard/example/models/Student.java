package codemeek.dropwizard.example.models;

import org.hibernate.transform.Transformers;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */

@Entity
@Table(name = "student")
@NamedQueries({
        @NamedQuery(name="dropwizard.models.student.findAll",query="Select std from Student std"),
        @NamedQuery(name="dropwizard.models.student.findByEmailId",query="Select std from Student std where std.emailId LIKE :emailId"),
        @NamedQuery(name="dropwizard.models.student.findById",query="Select std from Student std where std.studentId = :studentId")
})
public class Student {
    @Id
    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "name", nullable = false)
    private String name;

    private String emailId, branch;
    private int age,year;

    @ManyToOne
    @JoinColumn(name = "collegeId")
    private College college;

//    @Embedded
//    private Address address;


    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
