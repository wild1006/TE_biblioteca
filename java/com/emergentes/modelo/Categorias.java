package com.emergentes.modelo;

public class Categorias {
   private int id;
   private String categoria;

    public Categorias() {
    }  
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return "Categorias{" + "id=" + id + ", categoria=" + categoria + '}';
    }  
}
