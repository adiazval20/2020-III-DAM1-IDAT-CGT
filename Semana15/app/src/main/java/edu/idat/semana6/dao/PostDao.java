package edu.idat.semana6.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.idat.semana6.entity.Post;

@Dao
public interface PostDao {
    @Query("SELECT * FROM Post")
    LiveData<List<Post>> list();

    @Query("SELECT * FROM Post WHERE dbId = :id")
    LiveData<Post> find(long id);

    @Insert
    long create(Post post);

    @Update
    void update(Post post);

    @Delete
    void delete(Post post);

    @Query("DELETE FROM post")
    void clear();

    @Query("DELETE FROM Post WHERE dbId = :id")
    void deleteById(long id);
}
