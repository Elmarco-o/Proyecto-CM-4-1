package com.example.ficgame;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    // Método llamado cuando se hace clic en el botón "Iniciar Sesión"
    public void login(View view) {
        // Obtén las credenciales
        EditText emailEditText = findViewById(R.id.edtEmail);
        EditText passwordEditText = findViewById(R.id.edtPassword);

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
    }

    // Método llamado cuando se hace clic en el botón "Crear Cuenta"
    public void createAccount(View view) {
        // Aquí puedes agregar la lógica para ir a la actividad de registro
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    // Método de ejemplo para verificar credenciales (debes adaptarlo según tu lógica de autenticación)
    private boolean isValidCredentials(String email, String password) {
        // Aquí deberías realizar la autenticación con tu lógica específica
        // Por ejemplo, comparar con datos almacenados en una base de datos
        // En este ejemplo, simplemente compararemos con valores fijos
        return email.equals("usuario@example.com") && password.equals("contrasena123");
    }

}
