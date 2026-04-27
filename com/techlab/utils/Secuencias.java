package com.techlab.utils;

public final class Secuencias {

    private static int secuenciaArticulo = 0;
    private static int secuenciaCategoria = 0;

    private Secuencias() {
    }

    public static int generarCodigoArticulo() {
        secuenciaArticulo++;
        return secuenciaArticulo;
    }

    public static int generarCodigoCategoria() {
        secuenciaCategoria++;
        return secuenciaCategoria;
    }
}
