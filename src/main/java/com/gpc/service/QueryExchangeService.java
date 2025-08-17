package com.gpc.service;

import com.gpc.dto.QueryExchangeDTO;

public interface QueryExchangeService {

    long countQueryExchangeByDniAndFecha(String dni, String fecha);

    QueryExchangeDTO getTodayExchange(String dni);
}
