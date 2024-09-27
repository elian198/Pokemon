package com.pokemon.entities;

import com.pokemon.entities.enums.Fase;
import com.pokemon.entities.enums.Tipo;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "POKEMON")
@SQLDelete(sql = "UPDATE pokemon SET activo=false WHERE id = ?")
@Where(clause = "activo = false")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true, length = 20)
    private String nombre;
    @Column( length = 100)
    private String descripcion;
    private String imagen;
    @Enumerated(EnumType.STRING)
    private Set<Tipo> tipo = new HashSet<>();
    private BigDecimal peso;
    private Fase fase;
    private boolean activo;

    private Long identificador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Tipo> getTipo() {
        return tipo;
    }

    public void setTipo(Set<Tipo> tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", tipo=" + tipo +
                ", peso=" + peso +
                ", fase=" + fase +
                ", activo=" + activo +
                '}';
    }
}
