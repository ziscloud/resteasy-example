package com.kinhti.resteasy.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.kinhti.resteasy.domain.Student;

@Path("/students")
public class StudentService {

    @GET
    @Path("/{name}")
    @Produces("application/json")
    public Student produceJson( @PathParam("name") String name ) {

        Student st = new Student(name, "Marco",19,12);

        return st;

    }

    @POST
    @Consumes("application/json")
    public Response consumeJson(Student student) {
        String output = student.toString();
        return Response.status(200).entity(output).build();
    }
}