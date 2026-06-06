package com.escom.util.error;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Provider
public class PeriodoConflictoExceptionMapper implements ExceptionMapper<PeriodoConflictoException> {

    @Context
    jakarta.inject.Provider<ContainerRequestContext> containerRequestContextProvider;

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(PeriodoConflictoException ex) {
        log.error("Periodo conflicto error: ", ex);

        Map<String, Object> detail = new HashMap<>();
        detail.put("code", ex.getErrorCode());
        detail.put("message", ex.getErrorMessage());
        detail.put("examenesAfectados", ex.getExamenesAfectados());
        detail.put("path", null);

        Map<String, Object> body = new HashMap<>();
        body.put("status", Response.Status.BAD_REQUEST.getStatusCode());
        body.put("message", Response.Status.BAD_REQUEST.name());
        body.put("path", containerRequestContextProvider.get().getUriInfo().getPath());
        body.put("details", List.of(detail));

        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON)
                .entity(body)
                .build();
    }
}
