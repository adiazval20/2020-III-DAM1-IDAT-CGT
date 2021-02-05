package edu.idat.semana6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.idat.semana6.R;
import edu.idat.semana6.entity.Post;

public class PostAdapter extends ArrayAdapter<Post> {
    public PostAdapter(@NonNull Context context, int resource, @NonNull List<Post> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_post, parent, false);
        }

        Post post = getItem(position);

        ImageView imgPost = convertView.findViewById(R.id.imgPost);
        TextView txtTitulo = convertView.findViewById(R.id.txtTitulo);
        TextView txtDescripcion = convertView.findViewById(R.id.txtDescripcion);

//        imgPost.setImageResource(post.getUrlImagen());
        Picasso.get().load(post.getUrlImagen()).into(imgPost);

        txtTitulo.setText(post.getTitulo());
        txtDescripcion.setText(post.getDescripcion());

        return convertView;
    }
}
