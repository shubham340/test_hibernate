package codemeek.dropwizard.example;

import codemeek.dropwizard.example.dao.CollegeDao;
import codemeek.dropwizard.example.dao.StudentDao;
import codemeek.dropwizard.example.models.College;
import codemeek.dropwizard.example.models.Student;
import codemeek.dropwizard.example.resources.CollegeResource;
import codemeek.dropwizard.example.resources.StudentResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jitendragangwar on 5/1/17.
 */

public class DropApplication extends Application<DropConfiguration> {
    private static Logger log = LoggerFactory.getLogger(DropApplication.class); // declared a logger

    private final HibernateBundle<DropConfiguration> hibernateBundle
            = new HibernateBundle<DropConfiguration>(
            Student.class,College.class
    ) {

        @Override
        public DataSourceFactory getDataSourceFactory(
                DropConfiguration configuration
        ) {
            return configuration.getDataSourceFactory();
        }

    };

    public static void main(String[] args) throws Exception {
        new DropApplication().run(args);
    }
    @Override
    public void run(DropConfiguration configuration, Environment environment) throws Exception {
        log.info(" {} started ",configuration.getAppName());


        //Below we are creating objects using new and registering resource to environment
        //you have to do same thing ( registering resource ) but using guice injector
//        DemoService demoService = new DemoService();
//        environment.jersey().register(new DemoResource(configuration, demoService));

        final StudentDao studentDao = new StudentDao(hibernateBundle.getSessionFactory());
        final CollegeDao collegeDao = new CollegeDao(hibernateBundle.getSessionFactory());


        //Ignore below code
        environment.jersey().register(new StudentResource(studentDao));
        environment.jersey().register(new CollegeResource(collegeDao));
    }

    @Override
    public String getName() {
        return "Dropwizard Demo Example";
    }

    @Override
    public void initialize(Bootstrap<DropConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        //super.initialize(bootstrap);
        log.info("initialize project");
    }
}
