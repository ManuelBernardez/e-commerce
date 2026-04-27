package com.techlab.domain.model;

import com.techlab.domain.interfaces.Identificable;
import static com.techlab.utils.Validar.esVacio;

public class Categoria implements Identificable {

    private int codigo;
    private String nombre;
    private String descripcion;

    // Constructor.
    public Categoria(int codigo, String nombre, String descripcion){
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y setters
    @Override
    public int getCodigo() {
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nuevoNombre){
        if ( esVacio(nuevoNombre) )
            throw new Error("El nombre no puede estar vacío");

        this.nombre = nuevoNombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String nuevaDescripcion){
        this.descripcion = nuevaDescripcion;
    }

    @Override
    public String toString() {
        return "ID [" + codigo + "] - Nombre: " + nombre + " - Descripción: " + descripcion;
    }
}

