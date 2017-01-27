package com.monitora.android.nufscar.model;

import java.io.Serializable;

/**
 * Created by Murilo on 25/01/2017.
 */

public class Eventos implements Serializable {


    private String data;
    private String horario;
    private String idEventos;
    private String local;
    private String maisInformacao;
    private String realizacao;
    private String texto;
    private String titulo;
    private String url;


    public String getIdEventos() { return idEventos; }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getLocal() {
        return local;
    }

    public String getMaisInformacao() {
        return maisInformacao;
    }

    public String getRealizacao() {
        return realizacao;
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