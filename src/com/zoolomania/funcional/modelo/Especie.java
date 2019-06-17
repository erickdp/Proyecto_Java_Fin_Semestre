/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import com.zoolomania.funcional.control.util.UtilNumeros;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa al objeto especie
 * @author DELL
 */
public class Especie implements Serializable, Comparable<Especie>{
    
    private String nombreEspecie;
    private String nombreCientifico;
    private String descripcion;
    private List<Cuidador> cuiadores;
    /*
    Permite determinar a través de que atributo se ordenará la lista
     */
    public static boolean bandera = false;
    private short id; //Variable que permitirá ordenar objetos según su ID

    /**
     * Método contructor de la clase especie
     * @param nombreEspecie
     * @param nombreCientifico
     * @param descripcion
     * @param cuiadores 
     */
    public Especie(String nombreEspecie, String nombreCientifico, String descripcion, List<Cuidador> cuiadores) {
        this.nombreEspecie = nombreEspecie;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.cuiadores = cuiadores;
    }

    public List<Cuidador> getCuiadores() {
        return cuiadores;
    }

    public void setCuiadores(List<Cuidador> cuiadores) {
        this.cuiadores = cuiadores;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombreEspecie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Especie other = (Especie) obj;
        if (!Objects.equals(this.nombreEspecie, other.nombreEspecie)) {
            return false;
        }
        if (!Objects.equals(this.nombreCientifico, other.nombreCientifico)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }

    public short getId() {
        return id;
    }
    
    @Override
    public int compareTo(Especie otraEspecie) {
        if (!bandera) {
            return this.nombreEspecie.compareToIgnoreCase(otraEspecie.nombreEspecie);
        }
        return Short.compare(this.id, otraEspecie.id);
    }

    @Override
    public String toString() {
        return "Especie{" + "nombreEspecie=" + nombreEspecie + ", nombreCientifico=" + nombreCientifico + ", descripcion=" + descripcion + ", id=" + id + '}';
    }

}
