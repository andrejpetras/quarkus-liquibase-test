package com.github.andrejpetras.quarkus.liquibase;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloRestController {

    @GET
    @Produces(MediaType.MEDIA_TYPE_WILDCARD)
    public Response hello() {
        return Response.ok("hi 11\n").build();
    }
}
