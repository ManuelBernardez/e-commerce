package com.techlab.service;

import com.techlab.domain.repository.RepositorioGenerico;
import com.techlab.domain.model.Categoria;
import com.techlab.domain.exception.*;
import com.techlab.utils.Secuencias;

import java.util.List;

import static com.techlab.utils.Validar.esVacio;

public class CategoriaService {

    private final RepositorioGenerico<Categoria> repoCategorias;

    public CategoriaService(RepositorioGenerico<Categoria> repoCategorias) {
        this.repoCategorias = repoCategorias;
    }

    public void crear(String nombre, String descripcion) {

        // Validar duplicados
        for (Categoria c : repoCategorias.listado()) {
            if (c.getNombre().equalsIgnoreCase(nombre))
                throw new CategoriaDuplicadaException(nombre);
        }

        int codigo = Secuencias.generarCodigoCategoria();
        Categoria categoria = new Categoria(codigo, nombre, descripcion);

        repoCategorias.agregar(categoria);
    }

    public List<Categoria> listar() {
        return repoCategorias.listado();
    }

    public Categoria buscar(int codigo) {
        Categoria c = repoCategorias.buscarPorCodigo(codigo);

        if (c == null)
            throw new CategoriaNoEncontradaException(codigo);

        return c;
    }

    public void modificar(int codigo, String nombre, String descripcion) {

        Categoria c = buscar(codigo);

        System.out.println("Información actual:");
        System.out.println(c);

        for (Categoria cat : repoCategorias.listado()) {
            if (cat.getNombre().equalsIgnoreCase(nombre) && cat.getCodigo() != codigo)
                throw new CategoriaDuplicadaException("nombre");
        }

        if (!esVacio(nombre))
            c.setNombre(nombre);

        if (!esVacio(descripcion))
            c.setDescripcion(descripcion);
    }

    public void eliminar(int codigo) {
        Categoria c = buscar(codigo);
        repoCategorias.eliminar(c);
    }
}
