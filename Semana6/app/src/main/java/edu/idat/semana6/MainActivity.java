package edu.idat.semana6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana6.adapter.PostAdapter;
import edu.idat.semana6.entity.Post;

public class MainActivity extends AppCompatActivity {
    private ListView lsvPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsvPosts = findViewById(R.id.lsvPosts);

//        List<String> posts = new ArrayList<>();
//        posts.add("Publicación 1");
//        posts.add("Publicación 2");
//        posts.add("Publicación 3");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, posts);

        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "Publicación 1", "Descripción de publicación 1", R.drawable.img1));
        posts.add(new Post(2, "Publicación 2", "Descripción de publicación 2", R.drawable.img2));
        posts.add(new Post(3, "Publicación 3", "Descripción de publicación 3", R.drawable.img3));

        PostAdapter adapter = new PostAdapter(this, R.layout.item_post, posts);
        lsvPosts.setAdapter(adapter);
    }
}