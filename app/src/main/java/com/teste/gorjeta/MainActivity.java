package com.teste.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtConta;
    private TextView txtProgress, txtGorjeta, txtTotal;
    private double progresso;
    private SeekBar barra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtConta    = findViewById(R.id.inputConta);
        txtProgress = findViewById(R.id.txtProgresso);
        txtGorjeta  = findViewById(R.id.txtgorjeta);
        txtTotal    = findViewById(R.id.txtTotal);
        barra       = findViewById(R.id.barra);


        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progresso = i;
                txtProgress.setText(Math.round(progresso)+"%");
                calculo();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public void calculo(){
        String valorDigitado = txtConta.getText().toString();
        if (valorDigitado == null || valorDigitado.equals("")){

            Toast.makeText(
                    getApplicationContext(),
                    "Por favor digite um valor",
                    Toast.LENGTH_SHORT ).show();

        }
        else{
            Double valor = Double.parseDouble(valorDigitado);
            double gorjeta = valor * (progresso/100);
            txtGorjeta.setText("R$ " + gorjeta );

            double total = valor + gorjeta ;
            txtTotal.setText("R$ "+ total );

        }


    }
}