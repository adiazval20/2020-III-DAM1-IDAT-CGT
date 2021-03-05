package edu.idat.semana6.config;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.idat.semana6.dao.PostDao;
import edu.idat.semana6.entity.Post;

@Database(entities = {Post.class}, version = 1)
public abstract class DbConfig extends RoomDatabase {
    private static volatile DbConfig dbConfig;
    private static final int HILOS = 4;
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(HILOS);

    public abstract PostDao postDao();

    private static Callback initCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            dbExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Post post = new Post();
                    post.setId(1);
                    post.setTitulo("Publicación de prueba 1");
                    post.setDescripcion("Descripción de prueba 1");
                    post.setNombreImagen("JPG_20210305_001809_8363550784102608100.jpg");

                    PostDao dao = dbConfig.postDao();
                    dao.create(post);
                }
            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
        }
    };

    public static DbConfig getDbConfig(Context context) {
        if (dbConfig == null) {
            synchronized (DbConfig.class) {
                if (dbConfig == null) {
                    dbConfig = Room.databaseBuilder(context.getApplicationContext(), DbConfig.class, "DMA1-CGT")
                            .addCallback(initCallback)
                            .build();
                }
            }
        }
        return dbConfig;
    }
}
