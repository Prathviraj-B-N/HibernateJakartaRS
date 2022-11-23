package com.academicerp.backend;

import jakarta.ws.rs.ApplicationPath;
import com.academicerp.backend.Util.CORSFilter;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {
    public HelloApplication(){
        register(CORSFilter.class);
        packages("com.academicerp.backend");
    }
}