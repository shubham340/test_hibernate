package codemeek.dropwizard.example.dao;

import codemeek.dropwizard.example.models.College;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class CollegeDao extends AbstractDAO<College> {
    public CollegeDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<College> findAll(){
            return list(namedQuery("dropwizard.models.college.findAll"));
    }

    public Optional<College> findByID(String collegeId){
        return (Optional<College>) Optional.ofNullable(get(collegeId));
        //return (College) list(namedQuery("dropwizard.models.college.findById").setParameter("collegeId",collegeId)).get(0);
    }

    public College insertCollege(College college){
        return persist(college);
    }

}
