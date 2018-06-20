package codemeek.dropwizard.example.resources;

import codemeek.dropwizard.example.dao.CollegeDao;
import codemeek.dropwizard.example.models.College;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/college")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CollegeResource {
    private CollegeDao collegeDao;
    public  CollegeResource(CollegeDao collegeDao){
        this.collegeDao =collegeDao;
    }

    @GET
    @Path("/")
    @UnitOfWork
    public List<College>findAll(){
        return collegeDao.findAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<College> findById(@PathParam("id") String collegeId){
        Optional<College> college = collegeDao.findByID(collegeId);
        return college;
    }

    @POST
    @Path("/insert")
    @UnitOfWork
    public College insertCollege(@Valid College college){
        return collegeDao.insertCollege(college);
    }
}
