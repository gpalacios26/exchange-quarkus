package com.gpc.util;

import com.gpc.service.QueryExchangeService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;

@Singleton
public class DniValidator {

    @Inject
    QueryExchangeService service;

    public Response validate(String dni) {
        if (dni == null || dni.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"El parámetro dni es obligatorio\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        if (!dni.matches("\\d{8}")) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"El DNI debe tener exactamente 8 dígitos\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        LocalDate today = LocalDate.now();
        long consultasHoy = service.countQueryExchangeByDniAndFecha(dni, today.toString());
        if (consultasHoy >= 10) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"Límite de 10 consultas por día alcanzado\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        return null;
    }
}

