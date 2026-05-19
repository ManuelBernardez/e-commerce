package com.techlab.domain.model;

import static com.techlab.utils.Validar.esPositivo;

public class ProductoElectronico extends Producto {

    private double mesesGarantia;

    public ProductoElectronico(int codigo, String nombre, double precio, String categoria, double mesesGarantia) {
        super(codigo, nombre, precio, categoria);
        this.mesesGarantia = mesesGarantia;
    }

    public double getMesesGarantia() {
        return mesesGarantia;
    }

    @Override
    public double calcularPrecioFinal() {

        if (mesesGarantia > 12)
            return precio * 1.10;

        return precio;
    }

    @Override
    public String getTipoProducto(){
        return "Electrónico";
    }

        @Override
    public String getDetalleEspecifico(){
        return "Meses de garantía: " + (int)this.mesesGarantia;
    }
}
