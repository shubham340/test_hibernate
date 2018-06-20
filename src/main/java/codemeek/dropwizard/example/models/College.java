package codemeek.dropwizard.example.models;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shubham on 18/06/18.
 */
@Entity
@Table(name = "college")
@NamedQueries({
        @NamedQuery(name = "dropwizard.models.college.findAll", query = "select clg from College clg"),
        @NamedQuery(name = "dropwizard.models.college.findById", query = "select clg from College clg where clg.collegeId = :collegeId")
})
public class College {
    @Id
    private String collegeId;



//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="collegeId")
//    private Set<Student> Student = new HashSet<Student>();
//    public Set<codemeek.dropwizard.example.models.Student> getStudent() {
//        return Student;
//    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }
//
//    public void setStudent(Set<codemeek.dropwizard.example.models.Student> student) {
//        Student = student;
//    }

    private String name, city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

