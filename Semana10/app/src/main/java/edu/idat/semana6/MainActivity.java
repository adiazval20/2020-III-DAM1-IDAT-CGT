package edu.idat.semana6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        BottomNavigationView bnvSecciones = findViewById(R.id.bnvSecciones);
        bnvSecciones.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                loadFragment(item.getItemId());
                return true;
            }
        });
        loadFragment(R.id.optInicio);
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

    private void loadFragment(int itemId) {
        Fragment fragment = new Fragment();

        switch (itemId) {
            case R.id.optInicio:
                fragment = new InicioFragment();
                break;
            case R.id.optBuscar:
                fragment = new BuscarFragment();
                break;
            case R.id.optPerfil:
                fragment = new PerfilFragment();
                break;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frmContainer, fragment);
        transaction.commit();
    }
}