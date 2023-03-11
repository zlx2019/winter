package com.winter.example.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @author Zero.
 * @date 2023/3/10 10:27 PM
 */
@Path("/hello")
public class GreetingResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> hello(){
        return Map.of("name","zhangsan");
    }
}
