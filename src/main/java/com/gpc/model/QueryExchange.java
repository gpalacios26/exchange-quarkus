package com.gpc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QueryExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;

    private String fecha;

    private Double sunat;

    private Double compra;

    private Double venta;

    public QueryExchange() {
    }

    public QueryExchange(Long id, String dni, String fecha, Double sunat, Double compra, Double venta) {
        this.id = id;
        this.dni = dni;
        this.fecha = fecha;
        this.sunat = sunat;
        this.compra = compra;
        this.venta = venta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getSunat() {
        return sunat;
    }

    public void setSunat(Double sunat) {
        this.sunat = sunat;
    }

    public Double getCompra() {
        return compra;
    }

    public void setCompra(Double compra) {
        this.compra = compra;
    }

    public Double getVenta() {
        return venta;
    }

    public void setVenta(Double venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "QueryExchange{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", fecha='" + fecha + '\'' +
                ", sunat=" + sunat +
                ", compra=" + compra +
                ", venta=" + venta +
                '}';
    }
}
