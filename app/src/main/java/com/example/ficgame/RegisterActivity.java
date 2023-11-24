package com.example.ficgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializar vistas
        editTextNombre = findViewById(R.id.edtNombre);
        editTextEmail = findViewById(R.id.edtEmail);
        editTextPassword = findViewById(R.id.edtPassword);
        Button buttonRegister = findViewById(R.id.buttonRegister);

        // Configurar el clic del botón
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reemplaza la URL con la dirección de tu servidor
                EjecutarServidor("http://192.169.1.7:8080/xampp/htdocs/tarea3 hora android/validar");
            }
        });

    }

    private void EjecutarServidor(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Imprime la respuesta para depuración
                        System.out.println("Respuesta del servidor: " + response);

                        // Verifica si la respuesta indica éxito (ajusta esto según tu implementación)
                        if (response.equals("Registro exitoso")) {
                            Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Error en el registro", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Imprime el error para depuración
                        System.out.println("Error en la solicitud: " + error.toString());

                        Toast.makeText(getApplicationContext(), "Error en la solicitud", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("Nombre", editTextNombre.getText().toString());
                parametros.put("Email", editTextEmail.getText().toString());
                parametros.put("Password", editTextPassword.getText().toString());
                return parametros;
            }
        };

        // Asegúrate de que la cola de solicitudes se inicialice solo una vez (por ejemplo, en la aplicación)
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
