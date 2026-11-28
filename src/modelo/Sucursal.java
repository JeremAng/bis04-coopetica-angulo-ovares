/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;
/**
 *
 * @author jerea
 */
public class Sucursal {
    
    private String codigo;
    private String nombre;
    
    /**
     * Construye una nueva sucursal validando que el código y el nombre no estén vacíos.
     *
     * @param codigo Identificador único de la sucursal (ej. "SUC-01").
     * @param nombre Nombre descriptivo de la sucursal (ej. "Heredia Centro").
     * @throws IllegalArgumentException si el código o el nombre son nulos o están en blanco.
     */
    
    public Sucursal(String codigo, String nombre) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código de la sucursal no puede estar vacío.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la sucursal no puede estar vacío.");
        }
        this.codigo = codigo.trim();
        this.nombre = nombre.trim();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código de la sucursal no puede estar vacío.");
        }
        this.codigo = codigo.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la sucursal no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    /**
     * Compara dos sucursales por su código único (ignorando mayúsculas/minúsculas).
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Sucursal otra = (Sucursal) obj;
        return this.codigo.equalsIgnoreCase(otra.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo.toLowerCase());
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
    
    
}
