package edu.idat.semana6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class UserActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText edtUsername, edtPassword;
    private Button btnGuardar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        auth = FirebaseAuth.getInstance();

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar = findViewById(R.id.btnCancelar);

        Context context = this;
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(context, "Debe ingresar usuario y contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    crearUsuario(username, password);
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void crearUsuario(String username, String password) {
        Activity context = this;

        auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(context, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    String mensaje = "";
                    String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();

                    switch (errorCode) {
                        case "ERROR_INVALID_EMAIL":
                            mensaje = "El email no tiene un formato correcto";
                            break;
                        case "ERROR_EMAIL_ALREADY_IN_USE":
                            mensaje = "El email ya se encuentra registrado";
                            break;
                    }
//                    try {
//                        throw task.getException();
//                    } catch (FirebaseAuthInvalidCredentialsException ex) {
//                        mensaje = "El email no tiene un formato correcto";
//                    } catch (FirebaseAuthUserCollisionException ex) {
//                        mensaje = "El email ya se encuentra registrado";
//                    } catch (Exception e) {
//                        mensaje = "Se produció un error en el sistema";
//                        e.printStackTrace();
//                    }
                    Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}