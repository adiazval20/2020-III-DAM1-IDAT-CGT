package edu.idat.semana6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.idat.semana6.entity.Post;
import edu.idat.semana6.repository.PostRepository;

public class PostDataActivity extends AppCompatActivity {
    private final int REQUEST_IMAGE_CAPTURE = 1;
    private final int REQUEST_IMAGE_FILE = 2;
    private FirebaseStorage storage;
    private EditText edtTitulo, edtDescripcion;
    private Button btnTomarFoto, btnCancelar, btnGuardar;
    private ImageView imgFoto;
    private Bitmap miniatura;
    private String rutaFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);

        storage = FirebaseStorage.getInstance();

        edtTitulo = findViewById(R.id.edtTitulo);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        btnTomarFoto = findViewById(R.id.btnTomarFoto);
        imgFoto = findViewById(R.id.imgFoto);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarCamara(true);
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
                File foto = new File(rutaFoto);

                Post post = new Post();
                post.setTitulo(edtTitulo.getText().toString());
                post.setDescripcion(edtDescripcion.getText().toString());
                post.setUrlImagen(rutaFoto);
                post.setNombreImagen(foto.getName());
                PostRepository.save(post);

                uploadFile(foto);
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
                    miniatura = (Bitmap) extras.get("data");
                    imgFoto.setImageBitmap(miniatura);
                }
                break;
            case REQUEST_IMAGE_FILE:
                Bitmap foto = BitmapFactory.decodeFile(rutaFoto);
                imgFoto.setImageBitmap(foto);
                break;
        }
    }

    private void cargarCamara(boolean crearArchivo) {
        Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (camaraIntent.resolveActivity(getPackageManager()) != null) {
            if (crearArchivo) {
                File foto = null;
                try {
                    foto = crearArchivoFoto();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (foto != null) {
                    Uri uri = FileProvider.getUriForFile(this, "edu.idat.semana6.fileProvider", foto);
                    camaraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(camaraIntent, REQUEST_IMAGE_FILE);
                }
            } else {
                startActivityForResult(camaraIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    private File crearArchivoFoto() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String nombreArchivo = "JPG_" + timestamp + "_";
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File foto = File.createTempFile(nombreArchivo, ".jpg", directorio);
        rutaFoto = foto.getAbsolutePath();
        return foto;
    }

    private void uploadFile(File file) {
        // Ruta en la nube donde se va a almacenar el archivo
        String ruta = "fotos/" + file.getName();

        // Obtengo la referencia de la ruta en la nube
        StorageReference reference = storage.getReference(ruta);

        Uri uri = Uri.fromFile(file);
        Context context = this;

        UploadTask tareaSubir = reference.putFile(uri);
        tareaSubir.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(context, "Archivo subido correctamente", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                finish();
            }
        });
    }
}