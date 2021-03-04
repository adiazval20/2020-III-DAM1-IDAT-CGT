package edu.idat.semana6.repository;

import java.util.ArrayList;
import java.util.List;

import edu.idat.semana6.entity.Post;

public class PostRepository {
    private static List<Post> posts;

    static {
        posts = new ArrayList<>();
//        posts.add(new Post(1, "Publicación 1", "Descripción de publicación 1", "https://i.blogs.es/85a586/esvyedyxmauatu5/500_190.jpg"));
//        posts.add(new Post(2, "Publicación 2", "Descripción de publicación 2", "https://i.blogs.es/75a8c5/samsung-galaxy-buds-pro-7-/500_190.jpg"));
//        posts.add(new Post(3, "Publicación 3", "Descripción de publicación 3", "https://i.blogs.es/1eef62/iss-03/375_142.jpg"));
    }

    public static List<Post> list() {
        return posts;
    }

    public static void save(Post post) {
        posts.add(post);
    }
}
