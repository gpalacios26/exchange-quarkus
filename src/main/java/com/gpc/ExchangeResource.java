package com.gpc;

import com.gpc.dto.QueryExchangeDTO;
import com.gpc.service.QueryExchangeService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;

@Path("/exchange")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExchangeResource {

    @Inject
    QueryExchangeService service;

    @GET
    @Transactional
    public Response getTodayExchange(@QueryParam("dni") String dni) {
        if (dni == null || dni.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"El parámetro dni es obligatorio\"}")
                    .build();
        }

        LocalDate today = LocalDate.now();
        long consultasHoy = service.countQueryExchangeByDniAndFecha(dni, today.toString());
        if (consultasHoy >= 10) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"Límite de 10 consultas por día alcanzado\"}")
                    .build();
        }

        QueryExchangeDTO queryExchangeDTO = service.getTodayExchange(dni);
        return Response.status(Response.Status.OK)
                .entity(queryExchangeDTO)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
