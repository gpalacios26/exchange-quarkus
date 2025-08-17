package com.gpc.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/")
public interface ExchangeClient {

    @GET
    @Path("today.json")
    @Produces(MediaType.APPLICATION_JSON)
    ExchangeResponse getTodayExchange();
}
