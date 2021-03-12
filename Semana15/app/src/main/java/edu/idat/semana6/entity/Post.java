package edu.idat.semana6.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Post {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long dbId;

    private String id;
    private String titulo;

    @SerializedName("text")
    private String descripcion;

    @SerializedName("image")
    private String urlImagen;
    private String nombreImagen;


    public Post() {

    }

    @Ignore
    public Post(long dbId, String titulo, String descripcion, String urlImagen) {
        this.dbId = dbId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public long getDbId() {
        return dbId;
    }

    public void setDbId(long dbId) {
        this.dbId = dbId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }
}
