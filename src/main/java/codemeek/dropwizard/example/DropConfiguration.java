package codemeek.dropwizard.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Data;
import javax.validation.constraints.*;
import javax.validation.Valid;
import io.dropwizard.db.DataSourceFactory;


/**
 * Created by jitendragangwar on 5/1/17.
 */
//@Data
public class DropConfiguration extends Configuration{

    @NotNull
    @Valid
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }
    private String appName;
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

}
