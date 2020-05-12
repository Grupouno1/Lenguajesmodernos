package com.example.pendienteyfunciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText x1;
    EditText x2;
    EditText y1;
    EditText y2;
    TextView pendiente;
    TextView funcion;
    Button btnPendiente;
    Button btnFuncion;

    final View.OnClickListener Listen = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            switch(v.getId()){

                case R.id.btnfuncion:
                    funcion.setText( CrearFuncion());
                    break;
                case R.id.btnpendiente:
                    pendiente.setText(CalcularPendiente());
                    break;


                default: break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x1 = (EditText) findViewById(R.id.x1);
        x2 = (EditText) findViewById(R.id.x2);
        y1 = (EditText) findViewById(R.id.y1);
        y2 = (EditText) findViewById(R.id.y2);
        pendiente = (TextView) findViewById(R.id.boxpendiente);
        funcion = (TextView) findViewById(R.id.boxfuncion);
        btnPendiente = (Button) findViewById(R.id.btnpendiente);
        btnFuncion = (Button) findViewById(R.id.btnfuncion);

        btnPendiente.setOnClickListener(Listen);
        btnFuncion.setOnClickListener(Listen);
    }

    protected String CalcularPendiente(){
        try {
            float fx1 = Float.parseFloat(x1.getText().toString());
            float fy1 = Float.parseFloat(y1.getText().toString());
            float fx2 = Float.parseFloat(x2.getText().toString());
            float fy2 = Float.parseFloat(y2.getText().toString());
            if (fx2 - fx1 == 0) {
                return  "0";
            }
            else{
                float pendiente = (fy2 - fy1) / (fx2 - fx1);
                String S_pendiente = String.valueOf(pendiente);
                return S_pendiente;
            }

        }
        catch (NumberFormatException e){
            return "ingresa un dato válido. no  válido son: 1.coordenadas vacías 2.usar una (,) en vez de (.) 3.ingresar letras ";
        }
    }

    protected String CrearFuncion(){
        try {
            //captura el valor de todos los input
            float parsex1 = Float.parseFloat(x1.getText().toString());
            float parsex2 = Float.parseFloat(x2.getText().toString());
            float parsey1 = Float.parseFloat(y1.getText().toString());
            float parsey2 = Float.parseFloat(y2.getText().toString());

            //verifica si las 2 coordenadas son iguales
            float resultado = (float) (parsex1+parsex2+parsey1+parsey2)/4;
            if(resultado == parsex1){

                return "no pueden ser los mismo puntos de coordenadas";

            }else{

                //realiza las operaciones matemáticas para obtener la funcion
                float restar_y = parsey2 - parsey1;
                float restar_x = parsex2 - parsex1;

                if( (restar_x) == 0 ){
                    String constant = String.valueOf(parsey1);
                    return "y = "+constant;
                }else {

                    float m = restar_y/restar_x;
                    float b =  (m* -parsex1)+ parsey1;

                    // transformacion de los numeros a string para juntar  el X string con numeros float y poder crear una funcion
                    String mx = String.valueOf(m) + "x";
                    String string_b = String.valueOf((m * -parsex1)+parsey1);

                    //retorna la funcion
                    return  "y = "+mx+" + "+string_b;
                }

            }



        }catch (NumberFormatException e){
            return "ingresa un dato válido. no  válido son: 1.coordenadas vacías 2.usar una (,) en vez de (.) 3.ingresar letras ";
        }



    }


}
