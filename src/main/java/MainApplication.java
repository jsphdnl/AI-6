import com.ai6.exceptions.InternalServerException;
import com.ai6.exceptions.ResourceNotFoundException;
import com.ai6.exceptions.ResourceNotFoundExceptionMapper;
import com.ai6.exceptions.UnAuthorizedExceptionMapper;
import com.ai6.repositories.UserRepository;
import com.ai6.resources.UserController;
import com.ai6.services.UserService;
import com.ai6.wrapper.CouchBaseWrapper;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/*
 * This Java source file was auto generated by running 'gradle buildInit --type java-library'
 * by 'bharath' at '4/24/17 10:26 PM' with Gradle 2.0
 *
 * @author bharath, @date 4/24/17 10:26 PM
 */
public class MainApplication extends Application<MainConfiguration>{

    public static void main(String[] args) throws Exception {
        new MainApplication().run(args);
    }

    /**
     * When the application runs, this is called after the {@link }s are run. Override it to add
     * providers, resources, etc. for your application.
     *
     * @param configuration the parsed {@link } object
     * @param environment   the application's {@link Environment}
     * @throws Exception if something goes wrong
     */
    @Override
    public void run(MainConfiguration configuration, Environment environment)
        throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Bucket bucket = CouchbaseCluster.create().openBucket(configuration.getCouchBaseBucket(), configuration.getCouchBasePassword());
        CouchBaseWrapper wrapper = new CouchBaseWrapper(bucket,mapper);

        environment.jersey().register(wrapper);
        environment.jersey().register(mapper);


        //Please user a DI
        UserRepository userRepository = new UserRepository(wrapper, mapper);
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);

        //Repositories
        environment.jersey().register(userController);
        //Services
/*        environment.jersey().register(UserService.class);
        //Controllers
        environment.jersey().register(UserController.class);*/


        //exception Mappers
        environment.jersey().register(InternalServerException.class);
        environment.jersey().register(ResourceNotFoundExceptionMapper.class);
        environment.jersey().register(UnAuthorizedExceptionMapper.class);
    }
}