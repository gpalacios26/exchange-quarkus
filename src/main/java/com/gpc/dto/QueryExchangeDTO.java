package com.gpc.dto;

public class QueryExchangeDTO {

    private String dni;

    private String fecha;

    private Double sunat;

    private Double compra;

    private Double venta;

    public QueryExchangeDTO() {
    }

    public QueryExchangeDTO(String dni, String fecha, Double sunat, Double compra, Double venta) {
        this.dni = dni;
        this.fecha = fecha;
        this.sunat = sunat;
        this.compra = compra;
        this.venta = venta;
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
        return "QueryExchangeDTO{" +
                "dni='" + dni + '\'' +
                ", fecha='" + fecha + '\'' +
                ", sunat=" + sunat +
                ", compra=" + compra +
                ", venta=" + venta +
                '}';
    }
}
