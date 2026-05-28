package com.ecommerce.presentation.console;

import java.util.List;
import java.util.Scanner;
import static com.ecommerce.utils.EntradaDatos.leerEntero;

public abstract class Menu {

    protected Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void mostrarMenu();
    public abstract void ejecutar();

    protected abstract void crear();
    protected abstract void listar();
    protected abstract void buscarPorCodigo();
    protected abstract void buscarPorNombre();
    protected void buscar() {

        int tipoBusqueda = leerEntero(scanner, "1: Buscar por código / 2: Buscar por nombre: ");

        switch (tipoBusqueda) {
            case 1:
                buscarPorCodigo();
                break;

            case 2:
                buscarPorNombre();
                break;

            default:
                System.out.println("Opción inválida");
        }


    }
    protected abstract void modificar();
    protected abstract void eliminar();

    protected <T> void mostrarLista(List<T> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay elementos cargados");
            return;
        }

        for (T elemento : lista)
            System.out.println(elemento);
    }

}