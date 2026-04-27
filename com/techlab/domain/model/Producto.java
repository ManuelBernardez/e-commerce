package com.techlab.domain.model;

import com.techlab.domain.repository.RepositorioGenerico;
import static com.techlab.utils.Validar.esVacio;
import com.techlab.domain.interfaces.*;

public abstract class Producto implements Calculable, Identificable
{
    protected int codigo;
    protected String nombre;
    protected double precio;
    protected Categoria categoria;
    RepositorioGenerico<Producto> repoArticulo;

    // Constructor
    public Producto(int codigo, String nombre, double precio, Categoria categoria){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Getters y setters.
    @Override
    public int getCodigo() {
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nuevoNombre){
        if (esVacio(nuevoNombre))
            System.out.println("El nombre no puede estar vacío");

        this.nombre = nuevoNombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double nuevoPrecio){
        this.precio = nuevoPrecio;
    }

    public abstract double calcularPrecioFinal();

    public abstract String getTipoArticulo();

    @Override
    public String toString() {
        return "ID [" + codigo + "] | Nombre: " + nombre + " | Precio: $" + precio + "Categoría: " + categoria;
    }
}

