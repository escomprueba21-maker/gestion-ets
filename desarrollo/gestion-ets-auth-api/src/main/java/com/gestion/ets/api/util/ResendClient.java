package com.gestion.ets.api.util;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "resend-api")
@RegisterProvider(ResendAuthFilter.class)
@Path("/emails")
public interface ResendClient {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    void send(ResendEmailRequest request);
}