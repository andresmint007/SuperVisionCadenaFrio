package com.medisuply.supervisioncadenafrio.dto;

import java.time.LocalDate;

public class EventDto {
    private String producto_id;
    private String tipo_evento;
    private LocalDate fecha_evento;
    private String descripcion_evento;
    private DataEvent datos_evento;

    public static class DataEvent {
        private double valor_temperatura;
        private String unidad;
        private String ubicacion;

        // Getters y setters
        public double getValor_temperatura() {
            return valor_temperatura;
        }
        public void setValor_temperatura(double valor_temperatura) {
            this.valor_temperatura = valor_temperatura;
        }
        public String getUnidad() {
            return unidad;
        }
        public void setUnidad(String unidad) {
            this.unidad = unidad;
        }
        public String getUbicacion() {
            return ubicacion;
        }
        public void setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
        }
    }

    // Getters y setters
    public String getProducto_id() {
        return producto_id;
    }
    public void setProducto_id(String producto_id) {
        this.producto_id = producto_id;
    }
    public String getTipo_evento() {
        return tipo_evento;
    }
    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }
    public LocalDate getFecha_evento() {
        return fecha_evento;
    }
    public void setFecha_evento(LocalDate fecha_evento) {
        this.fecha_evento = fecha_evento;
    }
    public String getDescripcion_evento() {
        return descripcion_evento;
    }
    public void setDescripcion_evento(String descripcion_evento) {
        this.descripcion_evento = descripcion_evento;
    }
    public DataEvent getDatos_evento() {
        return datos_evento;
    }
    public void setDatos_evento(DataEvent datos_evento) {
        this.datos_evento = datos_evento;
    }
}
