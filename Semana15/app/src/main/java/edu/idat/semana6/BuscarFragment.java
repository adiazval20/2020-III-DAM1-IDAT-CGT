package edu.idat.semana6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.idat.semana6.adapter.PostAdapter;
import edu.idat.semana6.entity.Post;
import edu.idat.semana6.viewmodel.InicioViewModel;

public class BuscarFragment extends Fragment {
    private RecyclerView rcvPosts;
    private InicioViewModel viewModel;
    private PostAdapter adapter;

    public BuscarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buscar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(InicioViewModel.class);

        rcvPosts = view.findViewById(R.id.rcvPosts);
        rcvPosts.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        adapter = new PostAdapter(R.layout.item_post_resume);
        rcvPosts.setAdapter(adapter);

        viewModel.listPost().observe((LifecycleOwner) getContext(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                adapter.loadData(posts);
            }
        });
    }
}