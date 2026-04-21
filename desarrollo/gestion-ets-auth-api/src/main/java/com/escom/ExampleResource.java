package com.escom;

import io.quarkus.mailer.Mail;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import io.quarkus.mailer.Mailer;
import jakarta.inject.Inject;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
public class ExampleResource {

    @Inject
    Mailer mailer;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/test-mail")
    public String send() {
    mailer.send(Mail.withText("ssandovalgaribay@gmail.com", "Test Quarkus", "Funciona el mailer!"));
        return "Enviado";
    }
}