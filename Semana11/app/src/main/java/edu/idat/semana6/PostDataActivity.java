package edu.idat.semana6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import edu.idat.semana6.entity.Post;
import edu.idat.semana6.repository.PostRepository;

public class PostDataActivity extends AppCompatActivity {
    private final int REQUEST_IMAGE_CAPTURE = 1;
    private EditText edtTitulo, edtDescripcion;
    private Button btnTomarFoto, btnCancelar, btnGuardar;
    private ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);

        edtTitulo = findViewById(R.id.edtTitulo);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        btnTomarFoto = findViewById(R.id.btnTomarFoto);
        imgFoto = findViewById(R.id.imgFoto);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarCamara();
            }
        });

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
                PostRepository.save(post);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_IMAGE_CAPTURE:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    Bitmap foto = (Bitmap) extras.get("data");
                    imgFoto.setImageBitmap(foto);
                }
                break;
        }
    }

    private void cargarCamara() {
        Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (camaraIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(camaraIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}