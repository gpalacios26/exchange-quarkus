package com.gpc.repository;

import com.gpc.model.QueryExchange;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QueryExchangeRepository implements PanacheRepository<QueryExchange> {

    public long countByDniAndFecha(String dni, String fecha) {
        return count("dni = ?1 and fecha = ?2", dni, fecha);
    }
}
