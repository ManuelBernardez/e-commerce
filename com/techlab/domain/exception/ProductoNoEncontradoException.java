package com.techlab.domain.exception;

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(int codigo) {
        super("No existe el producto con código: " + codigo);
    }
}