package edu.idat.semana6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.idat.semana6.entity.Post;
import edu.idat.semana6.repository.PostRepository;

public class PostDataActivity extends AppCompatActivity {
    private EditText edtTitulo, edtDescripcion, edtUrlImagen;
    private Button btnCancelar, btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);

        edtTitulo = findViewById(R.id.edtTitulo);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtUrlImagen = findViewById(R.id.edtUrlImagen);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post post = new Post();
                post.setTitulo(edtTitulo.getText().toString());
                post.setDescripcion(edtDescripcion.getText().toString());
                post.setUrlImagen(edtUrlImagen.getText().toString());
                PostRepository.save(post);
                finish();
            }
        });
    }
}