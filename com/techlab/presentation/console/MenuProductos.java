package com.techlab.presentation.console;

import static com.techlab.utils.EntradaDatos.*;
import com.techlab.service.ProductoService;
import com.techlab.domain.model.Producto;

import java.util.Scanner;

public class MenuProductos extends Menu {

    private final ProductoService productoService;

    public MenuProductos(Scanner scanner, ProductoService productoService) {
        super(scanner);
        this.productoService = productoService;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ PRODUCTOS ---");
        System.out.println("1 - Ingresar producto");
        System.out.println("2 - Listar producto");
        System.out.println("3 - Consultar producto");
        System.out.println("4 - Modificar producto");
        System.out.println("5 - Eliminar producto");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutar() {
        int opcion;

        do {
        mostrarMenu();
        opcion = leerEntero("Elija una opción(0-6): ");

        switch (opcion) {
            case 1:
                System.out.println("\n--- NUEVO PRODUCTO ---");
                crear();
                break;
            case 2:
                System.out.println("\n--- LISTADO DE PRODUCTOS ---");
                listar();
                break;
            case 3:
                System.out.println("\n--- CONSULTAR PRODUCTO ---");
                buscar();
                break;
            case 4:
                System.out.println("\n--- MODIFICAR PRODUCTOS ---");
                modificar();
                break;
            case 5:
                System.out.println("\n--- ELIMINAR PRODUCTOS ---");
                eliminar();
                break;
            case 0:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Error: Opción inválida.");
        }

        } while (opcion != 0);
    }

    @Override
    protected void crear() {

        String nombre = leerTexto("Ingrese nombre: ");
        double precio = leerDouble("Ingrese precio: ");

        // TODO: Implementar busqueda de productos y categoría por nombre
        int codigoCategoria = leerEntero("Código de categoría: ");

        try {
            productoService.crearProducto(nombre, precio, codigoCategoria);
            System.out.println("Producto creado correctamente");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void listar() {
        for (Producto p : productoService.listar()) {
            System.out.println(p);
        }
    }

    @Override
    protected void buscar() {

        int codigo = leerEntero("Ingrese el código: ");

        try {
            Producto p = productoService.buscar(codigo);
            System.out.println(p);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void modificar() {

        int codigo = leerEntero("Código del producto: ");
        String nombre = leerTexto("Nuevo nombre: ");
        double precio = leerDouble("Nuevo precio: ");

        try {
            productoService.modificar(codigo, nombre, precio);
            System.out.println("Producto modificado correctamente");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void eliminar() {

        int codigo = leerEntero("Ingrese el código: ");

        if (leerSiNo("¿Borrar definitivamente?")) {
            try {
                productoService.eliminar(codigo);
                System.out.println("Producto eliminado correctamente");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Operación cancelada");
        }
    }
}
