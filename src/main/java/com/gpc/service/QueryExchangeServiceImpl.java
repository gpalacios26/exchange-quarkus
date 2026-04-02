package com.gpc.service;

import com.gpc.client.ExchangeClient;
import com.gpc.client.ExchangeResponse;
import com.gpc.dto.QueryExchangeDTO;
import com.gpc.mapper.QueryExchangeMapper;
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

    @Inject
    QueryExchangeMapper mapper;

    @Override
    public long countQueryExchangeByDniAndFecha(String dni, String fecha) {
        return repository.countByDniAndFecha(dni, fecha);
    }

    @Override
    public QueryExchangeDTO getTodayExchange(String dni) {
        ExchangeResponse exchangeResponse = exchangeClient.getTodayExchange();
        QueryExchange entity = mapper.getQueryExchange(dni, exchangeResponse);
        repository.persist(entity);
        return mapper.getQueryExchangeDTO(entity);
    }
}
