package com.lista.nominaempleadoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.lista.nominaempleadoparcial.Modelo.Trabajador;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button calcularSalario;
    private EditText nombreTrabajador;
    private EditText salarioTrabajador;
    private EditText tiempoLaborado;

    private Spinner mes;
    private ArrayAdapter adapter;
    private ArrayList<String> meses = new ArrayList<>();
    private LinkedList<Trabajador> trabajadores;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreTrabajador = findViewById(R.id.nombreTrabajador);
        salarioTrabajador = findViewById(R.id.salarioTrabajador);
        trabajadores = new LinkedList<>();
        tiempoLaborado = findViewById(R.id.tiempoLaborado);
        mes = (Spinner) findViewById(R.id.listadoMes);
        calcularSalario = findViewById(R.id.btnCalcularSueldo);
        calcularSalario.setOnClickListener(this);

        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");
        meses.add("Mayo");
        meses.add("Junio");
        meses.add("Julio");
        meses.add("Agosto");
        meses.add("Septiembre");
        meses.add("Octubre");
        meses.add("Noviembre");
        meses.add("Disiembre");

        adapter = new ArrayAdapter( MainActivity.this, android.R.layout.simple_spinner_dropdown_item, meses);
        mes.setAdapter(adapter);
        mes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                String mesSeleccionado = (String) mes.getAdapter().getItem(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    } // Final De La Creacion

    @Override
    public void onClick(View view) {
           switch (view.getId()){
               case R.id.btnCalcularSueldo:
                   Trabajador trabajador = new Trabajador();
                   trabajador.setNombre(nombreTrabajador.getText().toString());
                   trabajador.setSalario(Integer.valueOf(salarioTrabajador.getText().toString()));
                   trabajador.setTiempoTrabajado(Integer.valueOf(tiempoLaborado.getText().toString()));
                   trabajador.setMes(mes);


           }
    }


}