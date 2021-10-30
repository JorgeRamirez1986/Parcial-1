package com.lista.nominaempleadoparcial.Modelo;

import android.widget.Spinner;

public class Trabajador {

    private String nombre;
    private Double salario;
    private Double tiempoTrabajado;
    private String mes;

    public Trabajador() {
        this.nombre = nombre;
        this.salario = salario;
        this.tiempoTrabajado = tiempoTrabajado;
        this.mes = mes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getTiempoTrabajado() {
        return tiempoTrabajado;
    }

    public void setTiempoTrabajado(Double tiempoTrabajado) {
        this.tiempoTrabajado = tiempoTrabajado;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
