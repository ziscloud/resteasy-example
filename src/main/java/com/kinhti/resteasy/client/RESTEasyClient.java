package com.kinhti.resteasy.client;

import com.kinhti.resteasy.domain.Student;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by tonywang on 1/26/15.
 */
public class RESTEasyClient {
    public static void main(String[] args) {
        Student st = new Student("Catain", "Hook", 10, 12);
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://localhost:8080/resteasy/api/students");
        Response response = target.request().post(Entity.entity(st, MediaType.APPLICATION_JSON));
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        System.out.println("Server Response:");
        System.out.println(response.readEntity(String.class));
        response.close();
    }
}
