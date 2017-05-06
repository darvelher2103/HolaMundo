package com.example.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText cajaNumeroUno;
    private EditText cajaNumeroDos;
    private TextView cajaResultado;
    int n1, n2, suma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaNumeroUno = (EditText)findViewById(R.id.txtNumeroUno);
        cajaNumeroDos = (EditText)findViewById(R.id.txtNumeroDos);
        cajaResultado = (TextView)findViewById(R.id.txtResultado);

    }


    public void calcular(View v){
        double suma, n1, n2;

        n1 = Double.parseDouble(cajaNumeroUno.getText().toString());
        n2 = Double.parseDouble(cajaNumeroDos.getText().toString());

        suma = n1+n2;
        cajaResultado.setText(""+suma);
        //cajaResultado.setText(String.valueOf(suma));
    }

    public void borrar(View v){
        cajaNumeroUno.setText("");
        cajaNumeroDos.setText("");
        cajaResultado.setText("");
        cajaNumeroUno.requestFocus();
    }


    public boolean validar(){
        if (cajaNumeroUno.getText().toString().isEmpty()){
            cajaNumeroUno.requestFocus();
            cajaNumeroUno.setError(this.getResources().getString(R.string.error_numero_uno));
            return false;
        }else if(cajaNumeroDos.getText().toString().isEmpty()){
            cajaNumeroDos.requestFocus();
            cajaNumeroDos.setError(this.getResources().getString(R.string.error_numero_dos));
            return false;
        }
        return  true;
    }

}
