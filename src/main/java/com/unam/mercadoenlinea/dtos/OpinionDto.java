package com.unam.mercadoenlinea.dtos;

import lombok.Data;

import javax.persistence.Column;

@Data
public class OpinionDto {
    public Long id;
    public String titulo;
    public String descripcion;
    public Long calificacion;
    public Long fk;

    public OpinionDto(){}

    public OpinionDto(String titulo, String descripcion, Long calificacion, Long fk) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.fk = fk;
    }

    public OpinionDto(Long id, String titulo, String descripcion, Long calificacion, Long fk) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.fk = fk;
    }
}
