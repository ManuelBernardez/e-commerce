package com.techlab.utils;

public final class Secuencias {

    private static int secuenciaProducto = 0;
    private static int secuenciaCategoria = 0;

    private Secuencias() {
    }

    public static int generarCodigoProducto() {
        secuenciaProducto++;
        return secuenciaProducto;
    }

    public static int generarCodigoCategoria() {
        secuenciaCategoria++;
        return secuenciaCategoria;
    }
}
