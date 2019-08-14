package com.example.root.sqllife;

import java.util.List;

public class Categoria {

    private String categoria;
    private int idCategoria;
    private List<Categoria> categorias;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}
