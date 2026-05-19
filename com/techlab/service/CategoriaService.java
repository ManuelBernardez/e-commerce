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

        validarDuplicadoNombre(nombre);
        Categoria categoria = new Categoria(Secuencias.generarCodigoCategoria(), nombre, descripcion);

        repoCategorias.agregar(categoria);
    }

    public List<Categoria> listar() {
        return repoCategorias.listado();
    }

    public Categoria buscarPorCodigo(int codigo) {
        Categoria c = repoCategorias.buscarPorCodigo(codigo);

        if (c == null)
            throw new CategoriaNoEncontradaException(codigo);

        return c;
    }

    public Categoria buscarPorNombre(String nombre) {

        Categoria c = repoCategorias.buscarPorNombre(nombre);

        if (c == null)
            throw new CategoriaNoEncontradaException(nombre);

        return c;
    }

    public void modificar(int codigo, String nombre, String descripcion) {

        Categoria c = buscarPorCodigo(codigo);

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
        Categoria c = buscarPorCodigo(codigo);
        repoCategorias.eliminar(c);
    }

    private void validarDuplicadoNombre(String nombre) {

        Categoria existente = repoCategorias.buscarPorNombre(nombre);

        if (existente != null)
            throw new CategoriaDuplicadaException(nombre);
    }
}
