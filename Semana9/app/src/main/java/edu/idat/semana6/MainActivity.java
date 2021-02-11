package edu.idat.semana6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana6.adapter.PostAdapter;
import edu.idat.semana6.entity.Post;
import edu.idat.semana6.repository.PostRepository;

public class MainActivity extends AppCompatActivity {
    private ListView lsvPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tlbMain);
        toolbar.setTitle("IdatGram");
        setSupportActionBar(toolbar);

        lsvPosts = findViewById(R.id.lsvPosts);

        PostAdapter adapter = new PostAdapter(this, R.layout.item_post, PostRepository.list());
        lsvPosts.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optCrearPost:
                Intent intent = new Intent(this, PostDataActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}