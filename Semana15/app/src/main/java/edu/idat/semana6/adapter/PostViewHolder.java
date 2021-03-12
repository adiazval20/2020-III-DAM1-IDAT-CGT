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
    private int layout;

    public PostViewHolder(@NonNull View itemView, int layout) {
        super(itemView);
        this.layout = layout;
        storage = FirebaseStorage.getInstance();

        imgPost = itemView.findViewById(R.id.imgPost);

        if (layout == R.layout.item_post) {
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
        }
    }

    public void loadData(Post post) {
        Picasso.get().load(post.getUrlImagen()).into(imgPost);

        if (layout == R.layout.item_post) {
            txtTitulo.setText(post.getTitulo());
            txtDescripcion.setText(post.getDescripcion());
        }
    }
}
