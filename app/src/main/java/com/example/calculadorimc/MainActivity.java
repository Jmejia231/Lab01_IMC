package com.example.calculadorimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DecimalFormat deci = new DecimalFormat("#.##");

        final EditText et_Altura = (EditText)findViewById(R.id.et_Altura);
        final EditText et_Peso = (EditText)findViewById(R.id.et_Peso);
        Button btn_Calcular = (Button)findViewById(R.id.btn_Calcular);
        final TextView tv_Resultado = (TextView)findViewById(R.id.tv_Resultado);
        final TextView tv_Recomendacion = (TextView)findViewById(R.id.tv_Recomendacion);


        btn_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso, altura, IMC;
                peso = Double.parseDouble(et_Peso.getText().toString());
                altura = Double.parseDouble(et_Altura.getText().toString());

                IMC = peso/Math.pow(altura,2);

                new DecimalFormat("#.##").format(IMC);

                if (IMC < 18.5) {
                    tv_Resultado.setText(deci.format(IMC));
                    tv_Recomendacion.setText(R.string.Recomendacion_1);
                }
                if (IMC >= 18.5 && IMC <= 24.9) {
                    tv_Resultado.setText(deci.format(IMC));
                    tv_Recomendacion.setText(R.string.Recomendacion_2);
                }

                if (IMC >= 25.0 && IMC <= 29.9) {
                    tv_Resultado.setText(deci.format(IMC));
                    tv_Recomendacion.setText(R.string.Recomendacion_3);
                }
                else if(IMC >= 30.00) {
                    tv_Resultado.setText(deci.format(IMC));
                    tv_Recomendacion.setText(R.string.Recomendacion_4);
                }
                    }
        });
    }
}