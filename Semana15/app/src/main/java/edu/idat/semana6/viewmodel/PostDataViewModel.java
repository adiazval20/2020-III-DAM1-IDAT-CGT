package edu.idat.semana6.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import edu.idat.semana6.entity.Post;
import edu.idat.semana6.repository.PostRepository;

public class PostDataViewModel extends AndroidViewModel {
    private PostRepository postRepo;

    public PostDataViewModel(@NonNull Application application) {
        super(application);
        postRepo = new PostRepository(application);
    }

    public void save(Post post) {
        postRepo.save(post);
    }
}
