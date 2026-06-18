package com.gestion.ets.api.util;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "resend-api")
@Path("/emails")
public interface ResendClient {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @ClientHeaderParam(name = "Authorization", value = "{com.gestion.ets.api.util.ResendClient.getAuthHeader}")
    void send(ResendEmailRequest request);

    default String getAuthHeader() {
        return "Bearer " + org.eclipse.microprofile.config.ConfigProvider.getConfig()
                .getValue("resend.api.key", String.class);
    }
}