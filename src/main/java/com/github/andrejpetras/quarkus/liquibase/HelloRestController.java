package com.github.andrejpetras.quarkus.liquibase;

import io.quarkus.runtime.StartupEvent;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

import javax.enterprise.event.Observes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/")
public class HelloRestController {

    @GET
    @Produces(MediaType.MEDIA_TYPE_WILDCARD)
    public Response hello() throws Exception {

        System.out.println("----------------");
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        final ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(contextClassLoader);
        final Set<String> changeLogs = Optional.ofNullable(resourceAccessor.list(null, "/db", true, true, false))
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        System.out.println("x-> " + changeLogs);
        return Response.ok("" + changeLogs).build();
    }

    public void init(@Observes StartupEvent event) throws Exception {
        hello();
    }
}
