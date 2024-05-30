package com.example.regladetres;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCantidad1, editTextPrecioUnitario1, editTextPrecioTotal1;
    private EditText editTextCantidad2, editTextPrecioUnitario2, editTextPrecioTotal2;
    private EditText editTextCantidad3, editTextPrecioUnitario3, editTextPrecioTotal3;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCantidad1 = findViewById(R.id.editTextCantidad1);
        editTextPrecioUnitario1 = findViewById(R.id.editTextPrecioUnitario1);
        editTextPrecioTotal1 = findViewById(R.id.editTextPrecio1);

        editTextCantidad2 = findViewById(R.id.editTextCantidad2);
        editTextPrecioUnitario2 = findViewById(R.id.editTextPrecioUnitario2);
        editTextPrecioTotal2 = findViewById(R.id.editTextPrecio2);

        editTextCantidad3 = findViewById(R.id.editTextCantidad3);
        editTextPrecioUnitario3 = findViewById(R.id.editTextPrecioUnitario3);
        editTextPrecioTotal3 = findViewById(R.id.editTextPrecio3);

        buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPrecioTotal();
            }
        });
    }

    private void calcularPrecioTotal() {
        calcularPrecioIndividual(editTextCantidad1, editTextPrecioUnitario1, editTextPrecioTotal1);
        calcularPrecioIndividual(editTextCantidad2, editTextPrecioUnitario2, editTextPrecioTotal2);
        calcularPrecioIndividual(editTextCantidad3, editTextPrecioUnitario3, editTextPrecioTotal3);
    }

    private void calcularPrecioIndividual(EditText editTextCantidad, EditText editTextPrecioUnitario, EditText editTextPrecioTotal) {
        String cantidadStr = editTextCantidad.getText().toString();
        String precioUnitarioStr = editTextPrecioUnitario.getText().toString();

        if (!cantidadStr.isEmpty() && !precioUnitarioStr.isEmpty()) {
            try {
                float cantidad = Float.parseFloat(cantidadStr);
                float precioUnitario = Float.parseFloat(precioUnitarioStr);

                float precioTotal = cantidad != 0 ? precioUnitario / cantidad : 0;

                editTextPrecioTotal.setText(String.valueOf(precioTotal));
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Por favor ingrese valores numéricos válidos.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Por favor complete todos los campos.", Toast.LENGTH_SHORT).show();
        }
    }
}