package com.gpc.service;

import com.gpc.client.ExchangeClient;
import com.gpc.client.ExchangeResponse;
import com.gpc.dto.QueryExchangeDTO;
import com.gpc.model.QueryExchange;
import com.gpc.repository.QueryExchangeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class QueryExchangeServiceImpl implements QueryExchangeService {

    @Inject
    @RestClient
    ExchangeClient exchangeClient;

    @Inject
    QueryExchangeRepository repository;

    @Override
    public long countQueryExchangeByDniAndFecha(String dni, String fecha) {
        return repository.countByDniAndFecha(dni, fecha);
    }

    @Override
    public QueryExchangeDTO getTodayExchange(String dni) {
        ExchangeResponse exchangeResponse = exchangeClient.getTodayExchange();
        QueryExchange entity = getQueryExchange(dni, exchangeResponse);
        repository.persist(entity);
        return getQueryExchangeDTO(entity);
    }

    private QueryExchange getQueryExchange(String dni, ExchangeResponse exchangeResponse) {
        QueryExchange queryExchange = new QueryExchange();
        queryExchange.setDni(dni);
        queryExchange.setFecha(exchangeResponse.fecha);
        queryExchange.setSunat(exchangeResponse.sunat);
        queryExchange.setCompra(exchangeResponse.compra);
        queryExchange.setVenta(exchangeResponse.venta);
        return queryExchange;
    }

    private QueryExchangeDTO getQueryExchangeDTO(QueryExchange queryExchange) {
        return new QueryExchangeDTO(
                queryExchange.getDni(),
                queryExchange.getFecha(),
                queryExchange.getSunat(),
                queryExchange.getCompra(),
                queryExchange.getVenta()
        );
    }
}
