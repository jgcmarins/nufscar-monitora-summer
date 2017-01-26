package com.monitora.android.nufscar.model;

/**
 * Created by Murilo on 25/01/2017.
 */

import java.util.ArrayList;
import java.util.List;

public class Response {

    private List<News> news = new ArrayList<News>();
    private List<Eventos> events = new ArrayList<Eventos>();


    public List<News> getAndroid() {
        return news;
    }
    public List<Eventos> getAndroidEventos() {
        return events;
    }

}