package com.lista.nominaempleadoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.lista.nominaempleadoparcial.Modelo.Trabajador;

import java.util.ArrayList;

public class CalcularSueldo extends AppCompatActivity implements View.OnClickListener {

    private Button volver;
    private TextView NombreTrabajador;
    private TextView SalarioTrabajador;
    private TextView TiempoLaborado;
    private TextView Prima;
    private TextView Vacaciones;
    private TextView Pension;
    private TextView Cesantias;
    private TextView Salud;
    private TextView Mes;
    private ArrayList<Trabajador> listTrabajador = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_sueldo);
        NombreTrabajador = findViewById(R.id.txtNombreTrabajador);
        SalarioTrabajador = findViewById(R.id.txtSueldoNeto);
        TiempoLaborado = findViewById(R.id.txtTiempoLaborado);
        Prima = findViewById(R.id.txtPrima);
        Vacaciones = findViewById(R.id.txtVacaciones);
        Pension = findViewById(R.id.txtPension);
        Cesantias = findViewById(R.id.txtCesantias);
        Salud = findViewById(R.id.txtSalud);
        Mes = findViewById(R.id.valorMes);

        Bundle intent = getIntent().getBundleExtra("extra");
        listTrabajador = (ArrayList<Trabajador>) (intent.getSerializable("list"));
        NombreTrabajador.setText(listTrabajador.get(0).getNombre().toString());
        Double prima = calcularPrima(listTrabajador.get(0).getSalario(),listTrabajador.get(0).getTiempoTrabajado());
        Prima.setText(prima.toString());

        Double vacaciones = calcularVacaciones(listTrabajador.get(0).getSalario(),listTrabajador.get(0).getTiempoTrabajado());
        Vacaciones.setText(vacaciones.toString());

        Double pension = calcularPensiones(listTrabajador.get(0).getSalario(),listTrabajador.get(0).getTiempoTrabajado());
        Pension.setText(pension.toString());

        Double salud = calcularSalud(listTrabajador.get(0).getSalario(),listTrabajador.get(0).getTiempoTrabajado());
        Salud.setText(salud.toString());

        volver = findViewById(R.id.btnVolver);
        volver.setOnClickListener(this);



    }

    private Double calcularSalud(Double salario, Double tiempoTrabajado) {
        double salud = 0;
        return salud;
    }

    private Double calcularPensiones(Double salario, Double tiempoTrabajado) {
        double pension = 0;
        return pension;
    }

    private Double calcularVacaciones(Double salario, Double tiempoTrabajado) {
        double vacaciones = 0;
        vacaciones = (salario * tiempoTrabajado)/720;
        return vacaciones;
    }

    private Double calcularPrima(Double salario, double tiempo) {
        double prima = 0;
        prima = (salario + tiempo)/360;
        return prima;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnVolver:
                Intent intent = new Intent(CalcularSueldo.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

}