package com.gestion.ets.api.util;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import org.eclipse.microprofile.config.ConfigProvider;

public class ResendAuthFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) {
        String apiKey = ConfigProvider.getConfig().getValue("resend.api.key", String.class);
        requestContext.getHeaders().add("Authorization", "Bearer " + apiKey);
    }
}