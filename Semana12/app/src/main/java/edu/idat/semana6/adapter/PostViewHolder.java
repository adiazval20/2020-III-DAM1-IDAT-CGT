package edu.idat.semana6.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import edu.idat.semana6.R;
import edu.idat.semana6.entity.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgPost;
    private TextView txtTitulo, txtDescripcion;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        imgPost = itemView.findViewById(R.id.imgPost);
        txtTitulo = itemView.findViewById(R.id.txtTitulo);
        txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
    }

    public void loadData(Post post) {
//        Picasso.get().load(post.getUrlImagen()).into(imgPost);
        imgPost.setImageBitmap(post.getImagen());
        txtTitulo.setText(post.getTitulo());
        txtDescripcion.setText(post.getDescripcion());
    }
}
