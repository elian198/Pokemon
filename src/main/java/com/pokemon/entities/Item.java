package com.pokemon.entities;

import com.pokemon.entities.enums.Tipo;
import jakarta.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    private String item;
    @Id
    private Tipo tipo;
    private String imagen;
    private Integer puntosNecesarios;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Integer getPuntosNecesarios() {
        return puntosNecesarios;
    }

    public void setPuntosNecesarios(Integer puntosNecesarios) {
        this.puntosNecesarios = puntosNecesarios;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item='" + item + '\'' +
                ", tipo=" + tipo +
                ", imagen='" + imagen + '\'' +
                ", puntosNecesarios=" + puntosNecesarios +
                '}';
    }
}
