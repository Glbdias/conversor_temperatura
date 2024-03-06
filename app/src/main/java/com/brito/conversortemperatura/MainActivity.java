package com.brito.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtCelsius;
    EditText txtFahrenheit;
    Button   btnConverter;
    Button   btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCelsius = findViewById(R.id.txtCelsius);
        btnConverter = findViewById(R.id.btnConverter);

        txtFahrenheit = findViewById(R.id.txtFahrenheit);
        btnLimpar = findViewById(R.id.btnLimpar);

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float celsius=0;
                float far=0;

                if(txtCelsius.getText().toString().isEmpty()){// Caixa Celcius está vazia
                    if(!txtFahrenheit.getText().toString().isEmpty()){ // Caixa Fahrenheit possui dados
                        far=Float.parseFloat(txtFahrenheit.getText().toString());
                        celsius = (far-32)/(float)1.8;
                        txtCelsius.setText(String.valueOf(celsius));

                    }
                }

                if(txtFahrenheit.getText().toString().isEmpty()){// Caixa Fahrenheit está vazia
                    if(!txtCelsius.getText().toString().isEmpty()){ // Caixa Celsius possui dados
                        celsius=Float.parseFloat(txtFahrenheit.getText().toString());
                        far = (celsius * (float) 1.8) + 32;
                        txtFahrenheit.setText(String.valueOf(far));

                    }
                }


            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                txtCelsius.getText().clear();
                txtFahrenheit.getText().clear();
                txtCelsius.requestFocus();
            }

        });

    }
}