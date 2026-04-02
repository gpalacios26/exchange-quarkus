package com.gpc;

import com.gpc.dto.QueryExchangeDTO;
import com.gpc.service.QueryExchangeService;
import com.gpc.util.DniValidator;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/exchange")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExchangeResource {

    @Inject
    QueryExchangeService service;

    @Inject
    DniValidator dniValidator;

    @GET
    @Transactional
    public Response getTodayExchange(@QueryParam("dni") String dni) {
        Response validation = dniValidator.validate(dni);
        if (validation != null) {
            return validation;
        }

        QueryExchangeDTO queryExchangeDTO = service.getTodayExchange(dni);
        return Response.status(Response.Status.OK)
                .entity(queryExchangeDTO)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
