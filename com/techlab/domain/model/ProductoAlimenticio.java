package com.techlab.domain.model;

import static com.techlab.utils.Validar.esPositivo;

public class ProductoAlimenticio extends Producto {

    private int diasParaVencimiento;

    public ProductoAlimenticio(int codigo, String nombre, double precio, Categoria categoria, int diasParaVencimiento){
        super(codigo, nombre, precio, categoria);
        this.diasParaVencimiento = diasParaVencimiento;
    }

    public int getDiasParaVencimiento() {
        return diasParaVencimiento;
    }

    public void setDiasParaVencimiento(int dias) {
        if(esPositivo(dias))
            this.diasParaVencimiento = dias;
        else
            System.out.println("Los días no pueden ser negativos");
    }

    @Override
    public String getTipoArticulo() {
        return "Artículo Alimenticio";
    }

    @Override
    public double calcularPrecioFinal() {

        if (diasParaVencimiento < 15)
            return precio * 0.7;

        return precio;
    }

    @Override
    public String toString() {
        return String.format(
                "ID [%d] | Nombre: %s | Precio: $%.2f | Vence en (días): %d | Categoría: %s",
                codigo,
                nombre,
                calcularPrecioFinal(),
                diasParaVencimiento,
                getTipoArticulo()
        );
    }
}
