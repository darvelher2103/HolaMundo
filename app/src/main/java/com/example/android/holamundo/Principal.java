package com.example.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText cajaNumeroUno;
    private EditText cajaNumeroDos;
    private TextView cajaResultado;
    private Spinner comboOpciones;
    private String[] opciones;
    private ArrayAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaNumeroUno = (EditText)findViewById(R.id.txtNumeroUno);
        cajaNumeroDos = (EditText)findViewById(R.id.txtNumeroDos);
        cajaResultado = (TextView)findViewById(R.id.txtResultado);

        opciones = this.getResources().getStringArray(R.array.opciones);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opciones);
        comboOpciones.setAdapter(adapter);

    }


    public void calcular(View v){
        int op;
        double n1,n2,res=0;
        if(validar()) {
            n1 = Double.parseDouble(cajaNumeroUno.getText().toString());
            n2 = Double.parseDouble(cajaNumeroDos.getText().toString());

            op = comboOpciones.getSelectedItemPosition();
            switch (op){
                case 0:
                    res = n1+n2;
                    break;
                case 1:
                    res = n1-n2;
                    break;
                case 2:
                    res = n1*n2;
                    break;
                case 3:
                    res = n1/n2;
                    break;
            }


            cajaResultado.setText("" + res);
            cajaNumeroUno.requestFocus();

        }
    }


    public void borrar(View v){
        cajaNumeroUno.setText("");
        cajaNumeroDos.setText("");
        cajaResultado.setText("");
        cajaNumeroUno.requestFocus();
    }


    public boolean validar(){
        if(cajaNumeroUno.getText().toString().isEmpty()){
            cajaNumeroUno.requestFocus();
            cajaNumeroUno.setError(this.getResources().getString(R.string.error_numero_uno));
            return false;
        }
        if(cajaNumeroDos.getText().toString().isEmpty()){
            cajaNumeroDos.requestFocus();
            cajaNumeroDos.setError(this.getResources().getString(R.string.error_numero_dos));
            return false;
        }

        if(comboOpciones.getSelectedItemPosition()==3 && Double.parseDouble( cajaNumeroDos.getText().toString())==0){
            cajaNumeroDos.requestFocus();
            cajaNumeroDos.setError(this.getResources().getString(R.string.error_numero_dos_division));
            return false;
        }

        return true;
    }

}
