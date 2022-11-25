package com.academicerp.backend;

import jakarta.ws.rs.ApplicationPath;
import com.academicerp.backend.Util.CORSFilter;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class Main extends ResourceConfig {
    public Main(){
        register(CORSFilter.class);
        packages("com.academicerp.backend");
    }
}