package com.techlab.domain.repository;
import java.util.ArrayList;
import com.techlab.domain.interfaces.Identificable;

public class RepositorioGenerico<T extends Identificable> {

    private ArrayList<T> lista = new ArrayList<>();

    public void agregar (T objeto) {

        if (objeto == null)
            throw new IllegalArgumentException("Debe agregar un elemento válido");

        if ( buscarPorCodigo(objeto.getCodigo()) != null )
            throw new IllegalArgumentException("Ya existe un elemento con ese código");

        lista.add(objeto);
    }

    public ArrayList<T> listado() {
        return new ArrayList<>(lista);
    }

    public T buscarPorCodigo(int codigo){

        for(T objeto : lista){
            if(objeto.getCodigo() == codigo)
                return objeto;
        }

        return null;
    }

    public boolean eliminar(T objeto) {

        if (objeto != null){
            lista.remove(objeto);
            return true;
        }

        return false;
    }

    public boolean estaVacio() {
        return lista.isEmpty();
    }
}
