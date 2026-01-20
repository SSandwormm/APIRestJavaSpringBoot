package com.example.pokemon;

import java.util.List;

public class Pokemon {

    private String nombre;
    private List<String> tipos;
    private List<String> habilidades;
    private String nivel;
    private List<String> ataques;
    private List<String> debilidades;
    private List<String> fortalezas;
    private List<String> cuidados; // equivalente a “cuidados de enfermería”

    public Pokemon(String nombre, List<String> tipos, List<String> habilidades, String nivel,
                   List<String> ataques, List<String> debilidades,
                   List<String> fortalezas, List<String> cuidados) {
        this.nombre = nombre;
        this.tipos = tipos;
        this.habilidades = habilidades;
        this.nivel = nivel;
        this.ataques = ataques;
        this.debilidades = debilidades;
        this.fortalezas = fortalezas;
        this.cuidados = cuidados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<String> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<String> ataques) {
        this.ataques = ataques;
    }

    public List<String> getDebilidades() {
        return debilidades;
    }

    public void setDebilidades(List<String> debilidades) {
        this.debilidades = debilidades;
    }

    public List<String> getFortalezas() {
        return fortalezas;
    }

    public void setFortalezas(List<String> fortalezas) {
        this.fortalezas = fortalezas;
    }

    public List<String> getCuidados() {
        return cuidados;
    }

    public void setCuidados(List<String> cuidados) {
        this.cuidados = cuidados;
    }
}
