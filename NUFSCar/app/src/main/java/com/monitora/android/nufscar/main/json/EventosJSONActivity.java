package com.monitora.android.nufscar.main.json;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.monitora.android.nufscar.R;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.monitora.android.nufscar.model.Eventos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventosJSONActivity extends AppCompatActivity implements LoadJSONEventos.Listener, AdapterView.OnItemClickListener {

    private ListView mListView;

    public static final String URL = "https://ufscar-monitora.firebaseio.com/.json";

    private List<HashMap<String, String>> mAndroidMapList = new ArrayList<>();

    private static final String KEY_DATA = "data";
    private static final String KEY_HORARIO = "horario";
    private static final String KEY_LOCAL = "local";
    private static final String KEY_MAIS_INFORMACAO = "maisInformacao";
    private static final String KEY_REALIZACAO = "realizacao";
    private static final String KEY_TEXTO = "texto";
    private static final String KEY_TITULO = "titulo";
    private static final String KEY_URL = "url";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_view);

        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setOnItemClickListener(this);
        new LoadJSONEventos(this).execute(URL);
    }






    @Override
    public void onLoaded(List<Eventos> androidList) {

        for (Eventos android : androidList) {

            HashMap<String, String> map = new HashMap<>();


            map.put(KEY_DATA, android.getData());
            map.put(KEY_HORARIO, android.getHorario());
            map.put(KEY_LOCAL, android.getLocal());
            map.put(KEY_MAIS_INFORMACAO, android.getMaisInformacao());
            map.put(KEY_REALIZACAO, android.getRealizacao());
            map.put(KEY_TEXTO, android.getTexto());
            map.put(KEY_TITULO, android.getTitulo());
            map.put(KEY_URL, android.getUrl());

            mAndroidMapList.add(map);
        }

        loadListView();
    }

    @Override
    public void onError() {

        Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this, mAndroidMapList.get(i).get(KEY_TITULO),Toast.LENGTH_LONG).show();


    }

    private void loadListView() {

        ListAdapter adapter = new SimpleAdapter(EventosJSONActivity.this, mAndroidMapList, R.layout.activity_eventos,
                new String[] {  KEY_TITULO, KEY_DATA},
                new int[] {R.id.version,R.id.name});

        mListView.setAdapter(adapter);

    }
}