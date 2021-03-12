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
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana6.R;
import edu.idat.semana6.entity.Post;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private List<Post> posts;
    private int layout;

    public PostAdapter() {
        this.posts = new ArrayList<>();
        this.layout = R.layout.item_post;
    }

    public PostAdapter(int layout) {
        this.posts = new ArrayList<>();
        this.layout = layout;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new PostViewHolder(view, layout);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.loadData(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void loadData(List<Post> posts) {
        this.posts.clear();
        this.posts.addAll(posts);
        this.notifyDataSetChanged();
    }
}
