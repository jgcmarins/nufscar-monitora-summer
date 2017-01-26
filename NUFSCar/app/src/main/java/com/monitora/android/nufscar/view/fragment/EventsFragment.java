package com.monitora.android.nufscar.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.monitora.android.nufscar.R;
import com.monitora.android.nufscar.main.json.LoadJSONEventos;
import com.monitora.android.nufscar.model.Eventos;
import com.monitora.android.nufscar.view.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vdour on 26/01/2017.
 */

public class EventsFragment  extends Fragment implements LoadJSONEventos.Listener, AdapterView.OnItemClickListener {
    private View mListView;

    public static final String URL = "https://ufscar-monitora.firebaseio.com/.json";

    private List<HashMap<String, String>> mAndroidMapList = new ArrayList<>();

    public static final String KEY_DATA = "data";
    public static final String KEY_HORARIO = "horario";
    public static final String KEY_LOCAL = "local";
    public static final String KEY_MAIS_INFORMACAO = "maisInformacao";
    public static final String KEY_REALIZACAO = "realizacao";
    public static final String KEY_TEXTO = "texto";
    public static final String KEY_TITULO = "titulo";
    public static final String KEY_URL = "url";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mListView = inflater.inflate(R.layout.events_layout, container, false);
        mAndroidMapList = new ArrayList<>();

        new LoadJSONEventos(this).execute(URL);

        return this.mListView;
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
        //Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        // Toast.makeText(this, mAndroidMapList.get(i).get(KEY_TITULO),Toast.LENGTH_LONG).show();


    }

    private void loadListView() {

        /*ListAdapter adapter = new SimpleAdapter(NewsFeedFragment.this, mAndroidMapList, R.layout.list_item,
                new String[] {  KEY_TITULO, KEY_IMG, KEY_IDNOTICIA },
                new int[] {R.id.version,R.id.name, R.id.api });*/

        //mListView.setAdapter(adapter);

        ListView eventsListView = (ListView) this.mListView.findViewById(R.id.list_view_events);
        ListAdapter listAdapter = new ListAdapter(this.mAndroidMapList);
        eventsListView.setAdapter(listAdapter);

    }
}