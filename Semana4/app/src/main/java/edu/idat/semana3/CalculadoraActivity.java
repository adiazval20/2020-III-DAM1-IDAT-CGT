package edu.idat.semana3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class CalculadoraActivity extends AppCompatActivity {
    private TextView txtResultado;
    private EditText edtNumeroA, edtNumeroB;
    private MaterialButton btnSumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        txtResultado = findViewById(R.id.txtResultado);
        edtNumeroA = findViewById(R.id.edtNumeroA);
        edtNumeroB = findViewById(R.id.edtNumeroB);
        btnSumar = findViewById(R.id.btnSumar);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float numeroA = Float.parseFloat(edtNumeroA.getText().toString());
                float numeroB = Float.parseFloat(edtNumeroB.getText().toString());
                float resultado = numeroA + numeroB;
                txtResultado.setText(String.valueOf(resultado));
            }
        });
    }
}