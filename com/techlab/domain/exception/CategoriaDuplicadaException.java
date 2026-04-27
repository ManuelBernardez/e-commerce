package com.techlab.domain.exception;

public class CategoriaDuplicadaException extends RuntimeException {

    public CategoriaDuplicadaException(String nombre) {
        super("Ya existe una categoría con el nombre: " + nombre);
    }
}
