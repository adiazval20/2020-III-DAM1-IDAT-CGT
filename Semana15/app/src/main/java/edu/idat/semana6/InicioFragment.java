package edu.idat.semana6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import edu.idat.semana6.adapter.PostAdapter;
import edu.idat.semana6.entity.Post;
import edu.idat.semana6.repository.PostRepository;
import edu.idat.semana6.viewmodel.InicioViewModel;

public class InicioFragment extends Fragment {
    private InicioViewModel viewModel;

    private PostAdapter adapter;

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(InicioViewModel.class);

        RecyclerView rcvPosts = view.findViewById(R.id.rcvPosts);
        rcvPosts.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new PostAdapter();
        rcvPosts.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        viewModel.listPost().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                adapter.loadData(posts);
            }
        });
    }
}