package com.monitora.android.nufscar.view.fragment;

import android.app.Fragment;
import android.content.Intent;
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
import com.monitora.android.nufscar.model.News;
import com.monitora.android.nufscar.view.EventsDetailsActivity;
import com.monitora.android.nufscar.view.adapter.EventsListAdapter;
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

    private List<Eventos> mAndroidMapList = new ArrayList<>();


    public static final String KEY_IDEVENTO = "idEvento";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mListView = inflater.inflate(R.layout.events_layout, container, false);
        mAndroidMapList = new ArrayList<Eventos>();

        new LoadJSONEventos(this).execute(URL);

        return this.mListView;
    }

    @Override
    public void onLoaded(List<Eventos> androidList) {
        for (Eventos android : androidList) {


            mAndroidMapList.add(android);
        }

        ListView listView = loadListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Eventos evento = (Eventos) parent.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), EventsDetailsActivity.class);
                intent.putExtra(KEY_IDEVENTO,evento);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onError() {
        //Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {




    }

    private ListView loadListView() {

        /*ListAdapter adapter = new SimpleAdapter(NewsFeedFragment.this, mAndroidMapList, R.layout.list_item,
                new String[] {  KEY_TITULO, KEY_IMG, KEY_IDNOTICIA },
                new int[] {R.id.version,R.id.name, R.id.api });*/

        //mListView.setAdapter(adapter);

        ListView eventsListView = (ListView) this.mListView.findViewById(R.id.list_view_events);
        EventsListAdapter listAdapter = new EventsListAdapter(this.mAndroidMapList);
        eventsListView.setAdapter(listAdapter);

        return eventsListView;

    }
}