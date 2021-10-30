package com.lista.nominaempleadoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MostrarSueldo extends AppCompatActivity implements View.OnClickListener{
        private Button calcularSalario;
        private EditText nombreTrabajador;
        private EditText sueldoTrabajador;
        private EditText cantDiasLaborados;
        private Spinner mes;
        private ArrayList<String> meses = new ArrayList<>();
        private ArrayAdapter adapter;
        public  Double diasAnno = 360.0;
        public  Double auxTransport = 106454.0;
        public  Double salarioMin = 908526.0;

        private TextView NombreTrabajador;
        private TextView SueldoTrabajador;
        private TextView Prima;
        private TextView Vacaciones;
        private TextView Pension;
        private TextView Cesantias;
        private TextView Salud;
        private TextView Cajas;
        private TextView Mes;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mostrar_sueldo);

            nombreTrabajador = findViewById(R.id.nombreTrabajador);
            cantDiasLaborados = findViewById(R.id.diasLaborados);
            sueldoTrabajador = findViewById(R.id.sueldoTrabajador);
            mes = (Spinner) findViewById(R.id.listadoMes);


            calcularSalario = findViewById(R.id.btnCalcular);
            calcularSalario.setOnClickListener(this);



            NombreTrabajador = findViewById(R.id.textNombreTrabajador);
            SueldoTrabajador = findViewById(R.id.textSueldoTrabajador);
            Prima = findViewById(R.id.textPrima);
            Vacaciones = findViewById(R.id.textVacaciones);
            Pension = findViewById(R.id.textPension);
            Cesantias = findViewById(R.id.texCesantias);
            Salud = findViewById(R.id.textSalud);
            Mes =  findViewById(R.id.valorMes);
            Cajas = findViewById(R.id.cajasCompensacion);


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
            meses.add("Diciembre");
            adapter = new ArrayAdapter(MostrarSueldo.this, android.R.layout.simple_spinner_dropdown_item, meses);
            mes.setAdapter(adapter);
            mes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String mesSeleccionado = (String) mes.getAdapter().getItem(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        @Override
        public void onClick(View view) {switch (view.getId()){
            case R.id.btnCalcular:
                String nombre = nombreTrabajador.getText().toString();
                Double salario = (Double.valueOf(sueldoTrabajador.getText().toString()));
                Double cantDias = (Double.valueOf(cantDiasLaborados.getText().toString()));
                String meses = (String) mes.getSelectedItem();

                if(nombre != null && salario != null && mes != null && cantDias != null){
                    Toast.makeText(this, "el Nombre del Empleado es" + nombre + "el Salario del Empleado es: "+ salario +
                            "el Salario del Empleado es: "+ mes, Toast.LENGTH_LONG).show();
                    this.clearForm();

                    Double valorPrima = calcularPrima(salario,meses, cantDias);
                    Double valorCesantiaas = calcularCesantias(salario,meses, cantDias);
                    Double salud = calcularSalud(salario);
                    Double pension = calcularPension(salario);
                    Double vacaciones = calcularVacaciones(salario, cantDias);
                    Double cajas = calcularCajasCompensacion(salario);
                    Double salarioFinal = calcularSalario(salario,valorPrima, valorCesantiaas, salud, pension, vacaciones, cajas);


                    NombreTrabajador.setText(nombre);
                    Prima.setText((String) valorPrima.toString());
                    Vacaciones.setText((String) vacaciones.toString());
                    //validación de salario mínimo
                    if(pension==0.0){
                        Pension.setText("Revisar planilla");
                        Toast.makeText(this, "El salario debe ser cotizado sobre el smlv", Toast.LENGTH_LONG).show();

                    }else{
                        Pension.setText((String) pension.toString());
                    }
                    Cesantias.setText((String) valorCesantiaas.toString());
                    //validación de salario mínimo
                    if(salud==0.0){
                        Salud.setText("Revisar planilla");
                        Toast.makeText(this, "El salario debe ser cotizado sobre el smlv", Toast.LENGTH_LONG).show();

                    }else{
                        Salud.setText((String) salud.toString());
                    }
                    SueldoTrabajador.setText((String) salarioFinal.toString());
                    //validación de salario mínimo
                    if(cajas==0.0){
                        Cajas.setText("Revisar planilla");
                        Toast.makeText(this, "El salario debe ser cotizado sobre el smlv", Toast.LENGTH_LONG).show();

                    }else{
                        Cajas.setText((String) cajas.toString());
                    }

                }else{
                    Toast.makeText(this, "NO se registraron datos", Toast.LENGTH_LONG).show();
                }
                break;
        }
        }//END onClick

        public void clearForm(){
            nombreTrabajador.getText().clear();
            sueldoTrabajador.getText().clear();
        }

        public Double calcularPrima (Double salario, String mes, Double cantidad){
            Double valorPrima = 0.0;
            if(mes == "Junio" || mes == "Diciembre"){
                valorPrima = (((salario+auxTransport)*cantidad)/diasAnno);
            }
            return  valorPrima;
        }

        public Double calcularCesantias (Double salario, String mes, Double cantidad){
            Double valorCesantiaas = 0.0;
            if(mes == "Enero" ){
                valorCesantiaas = (((salario+auxTransport)*cantidad)/diasAnno);
            }
            return  valorCesantiaas;
        }

        public Double calcularVacaciones (Double salario,  Double cantidad){
            Double vacaciones = ((salario*cantidad)/720);
            return  vacaciones;
        }

        public Double calcularSalud (Double salario){
            Double salud = 0.0;
            if(salario <= salarioMin){
                salud = 0.0;
            }else{
                salud = ((salario*0.04));
            }
            return  salud;
        }

        public Double calcularPension (Double salario){
            Double pension = 0.0;
            if(salario <= salarioMin){
                pension = 0.0;
            }else{
                pension = ((salario*0.04));
            }
            return  pension;
        }
        public Double calcularCajasCompensacion (Double salario){
            Double pension = 0.0;
            if(salario <= salarioMin){
                pension = 0.0;
            }else{
                pension = ((salario*0.04));
            }
            return  pension;
        }
        public Double calcularSalario(Double salario, Double valorPrima, Double valorCesantiaas, Double salud, Double pension, Double vacaciones, Double cajas )
        {
            Double salarioFinal = 0.0;
            salarioFinal = (salario +valorPrima +valorCesantiaas-salud-pension+vacaciones-cajas);
            return salarioFinal;
        }

}

