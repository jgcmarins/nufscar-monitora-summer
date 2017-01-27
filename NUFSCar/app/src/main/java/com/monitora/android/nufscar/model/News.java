package com.monitora.android.nufscar.model;

import java.io.Serializable;

/**
 * Created by Murilo on 25/01/2017.
 */

public class News implements Serializable {

    private String autor;
    private String data;
    private String figcaption;
    private String idNoticia;
    private String image_src;
    private String texto;
    private String titulo;
    private String url;

    public String getAutor() {
        return autor;
    }

    public String getData() {
        return data;
    }

    public String getFigcaption() {
        return figcaption;
    }

    public String getIdNoticia() {
        return idNoticia;
    }

    public String getImg_src() {
        return image_src;
    }

    public String getTexto() {
        return texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }
}