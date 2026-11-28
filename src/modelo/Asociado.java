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
public class Asociado {
    
    
    private final String cedula;
    private String nombre;
    private final String numeroAsociado;
    private Sucursal sucursal;
    private double saldoAportes;


    
    /**
     * Construye un nuevo asociado con saldo de aportes inicial en cero.
     *
     * @param cedula Identificación única del asociado (inmutable).
     * @param nombre Nombre completo del asociado.
     * @param numeroAsociado Código interno único del asociado (inmutable).
     * @param sucursal Sucursal asignada al asociado.
     */
    
    public Asociado(String cedula, String nombre, String numeroAsociado, Sucursal sucursal) {
        this(cedula, nombre, numeroAsociado, sucursal, 0.0);
    }
    
    /**
     * Construye un asociado permitiendo indicar un saldo inicial (útil al cargar desde archivo).
     *
     * @param cedula Identificación única del asociado (inmutable).
     * @param nombre Nombre completo del asociado.
     * @param numeroAsociado Código interno único del asociado (inmutable).
     * @param sucursal Sucursal asignada al asociado.
     * @param saldoAportes Saldo inicial de aportes (mayor o igual a cero).
     */
    
    public Asociado(String cedula, String nombre, String numeroAsociado, Sucursal sucursal, double saldoAportes) {
        if (cedula == null || cedula.isBlank()) {
            throw new IllegalArgumentException("La cédula no puede estar vacía.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del asociado no puede estar vacío.");
        }
        if (numeroAsociado == null || numeroAsociado.isBlank()) {
            throw new IllegalArgumentException("El número de asociado no puede estar vacío.");
        }
        if (sucursal == null) {
            throw new IllegalArgumentException("El asociado debe pertenecer a una sucursal.");
        }
        if (saldoAportes < 0) {
            throw new IllegalArgumentException("El saldo de aportes inicial no puede ser negativo.");
        }
        this.cedula = cedula.trim();
        this.nombre = nombre.trim();
        this.numeroAsociado = numeroAsociado.trim();
        this.sucursal = sucursal;
        this.saldoAportes = saldoAportes;
    }
    
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del asociado no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getNumeroAsociado() {
        return numeroAsociado;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        if (sucursal == null) {
            throw new IllegalArgumentException("La sucursal no puede ser nula.");
        }
        this.sucursal = sucursal;
    }

    public double getSaldoAportes() {
        return saldoAportes;
    }
    
    /**
     * Retira un monto de los aportes del asociado sin permitir saldo negativo.
     *
     * @param monto Cantidad a retirar (mayor a 0 y menor o igual al saldo disponible).
     */
    
    public void retirarAporte(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
        }
        if (monto > this.saldoAportes) {
            throw new IllegalArgumentException("Fondos insuficientes en aportes para realizar el retiro.");
        }
        this.saldoAportes -= monto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Asociado otro = (Asociado) obj;
        return this.cedula.equalsIgnoreCase(otro.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula.toLowerCase());
    }

    @Override
    public String toString() {
        return numeroAsociado + " - " + nombre + " (Cédula: " + cedula + ")";
    }
        
}
