package edu.idat.semana6.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.idat.semana6.entity.Post;
import edu.idat.semana6.repository.PostRepository;

public class InicioViewModel extends AndroidViewModel {
    private PostRepository postRepo;

    public InicioViewModel(@NonNull Application application) {
        super(application);
        postRepo = new PostRepository(application);
    }

    public LiveData<List<Post>> listPost() {
        return postRepo.list();
    }
}
