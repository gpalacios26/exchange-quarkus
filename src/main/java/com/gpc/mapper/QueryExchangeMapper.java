package com.gpc.mapper;

import jakarta.enterprise.context.ApplicationScoped;

import com.gpc.client.ExchangeResponse;
import com.gpc.dto.QueryExchangeDTO;
import com.gpc.model.QueryExchange;

@ApplicationScoped
public class QueryExchangeMapper {

    public QueryExchange getQueryExchange(String dni, ExchangeResponse exchangeResponse) {
        QueryExchange queryExchange = new QueryExchange();
        queryExchange.setDni(dni);
        queryExchange.setFecha(exchangeResponse.fecha());
        queryExchange.setSunat(exchangeResponse.sunat());
        queryExchange.setCompra(exchangeResponse.compra());
        queryExchange.setVenta(exchangeResponse.venta());
        return queryExchange;
    }

    public QueryExchangeDTO getQueryExchangeDTO(QueryExchange queryExchange) {
        return new QueryExchangeDTO(
                queryExchange.getDni(),
                queryExchange.getFecha(),
                queryExchange.getSunat(),
                queryExchange.getCompra(),
                queryExchange.getVenta()
        );
    }
}
