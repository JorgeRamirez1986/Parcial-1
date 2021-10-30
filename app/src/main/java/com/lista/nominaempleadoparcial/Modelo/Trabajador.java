package com.lista.nominaempleadoparcial.Modelo;

import android.widget.Spinner;

public class Trabajador {

    private String nombre;
    private Integer salario;
    private Integer tiempoTrabajado;
    private Spinner mes;

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

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Integer getTiempoTrabajado() {
        return tiempoTrabajado;
    }

    public void setTiempoTrabajado(Integer tiempoTrabajado) {
        this.tiempoTrabajado = tiempoTrabajado;
    }

    public Spinner getMes() {
        return mes;
    }

    public void setMes(Spinner mes) {
        this.mes = mes;
    }
}
