package com.techlab.domain.model;

import static com.techlab.utils.Validar.esPositivo;

public class ProductoElectronico extends Producto {

    private double mesesGarantia;

    // Constructor
    public ProductoElectronico(int codigo, String nombre, double precio, Categoria categoria, double mesesGarantia) {
        super(codigo, nombre, precio, categoria);
        this.mesesGarantia = mesesGarantia;
    }

    // Getter
    public double getMesesGarantia() {
        return mesesGarantia;
    }

    // Setter con validación
    public void setMesesGarantia(double meses) {
        if(esPositivo(meses))
            this.mesesGarantia = meses;
        else
            System.out.println("Los meses no pueden ser negativos");
    }

    @Override
    public String getTipoArticulo() {
        return "Artículo Electrónico";
    }

    // Lógica de precio final
    @Override
    public double calcularPrecioFinal() {

        if (mesesGarantia > 12)
            return precio * 1.10;

        return precio;
    }

    @Override
    public String toString() {
        return String.format(
                "ID [%d] | Nombre: %s | Precio: $%.2f | Garantía (meses): %.0f | Categoría: %s",
                codigo,
                nombre,
                calcularPrecioFinal(),
                mesesGarantia,
                getTipoArticulo()
        );
    }
}
