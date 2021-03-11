package edu.idat.semana6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText edtUsername, edtPassword;
    private Button btnLogin, btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignin = findViewById(R.id.btnSignin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Debe ingresar usuario y contraseña", Toast.LENGTH_LONG).show();
                } else {
                    login(username, password);
                }
            }
        });

        Context context = this;
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, UserActivity.class));
            }
        });
    }

    private void login(String username, String password) {
        Activity context = this;

        auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = auth.getCurrentUser();
                    Toast.makeText(context, String.format("Bienvenido %s", user.getEmail()), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(context, HomeActivity.class));
                } else {
                    String mensaje = "";
                    String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();
                    switch (errorCode) {
                        case "ERROR_INVALID_EMAIL":
                            mensaje = "El usuario ingresado no tiene un formato válido";
                            break;
                        case "ERROR_USER_NOT_FOUND":
                            mensaje = "El usuario no existe";
                            break;
                        case "ERROR_WRONG_PASSWORD":
                            mensaje = "La contraseña es incorrecta";
                            break;
                    }
//                    Toast.makeText(context, errorCode, Toast.LENGTH_LONG).show();
                    Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}