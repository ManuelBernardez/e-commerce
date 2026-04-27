package com.techlab.utils;

public final class Validar {
    private Validar() {}

    public static boolean esVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean longitudMaxima(String texto, int maximo) {
        return esVacio(texto) && texto.length() <= maximo;
    }

    public static boolean esPositivo(double valor) {
        return valor >= 0;
    }
}
