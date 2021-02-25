package edu.idat.semana6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import edu.idat.semana6.adapter.PostAdapter;
import edu.idat.semana6.repository.PostRepository;

public class InicioFragment extends Fragment {

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
        RecyclerView rcvPosts = view.findViewById(R.id.rcvPosts);
        rcvPosts.setLayoutManager(new LinearLayoutManager(getContext()));

        PostAdapter adapter = new PostAdapter(PostRepository.list());
        rcvPosts.setAdapter(adapter);
    }
}