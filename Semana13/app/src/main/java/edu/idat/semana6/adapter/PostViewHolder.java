package edu.idat.semana6.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import edu.idat.semana6.R;
import edu.idat.semana6.entity.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private FirebaseStorage storage;
    private ImageView imgPost;
    private TextView txtTitulo, txtDescripcion;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        storage = FirebaseStorage.getInstance();

        imgPost = itemView.findViewById(R.id.imgPost);
        txtTitulo = itemView.findViewById(R.id.txtTitulo);
        txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
    }

    public void loadData(Post post) {
//        Picasso.get().load(post.getUrlImagen()).into(imgPost);
//        Bitmap foto = BitmapFactory.decodeFile(post.getUrlImagen());
//        imgPost.setImageBitmap(foto);

        try {
            File archivoLocal = File.createTempFile("images", "jpg");
            String ruta = "fotos/" + post.getNombreImagen();

            StorageReference reference = storage.getReference(ruta);
            reference.getFile(archivoLocal).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap foto = BitmapFactory.decodeFile(archivoLocal.getAbsolutePath());
                    imgPost.setImageBitmap(foto);
                    Toast.makeText(itemView.getContext(), "Imagen cargada!", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(itemView.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        txtTitulo.setText(post.getTitulo());
        txtDescripcion.setText(post.getDescripcion());
    }
}
