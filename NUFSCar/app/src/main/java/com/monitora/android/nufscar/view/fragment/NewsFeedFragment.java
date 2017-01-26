package com.monitora.android.nufscar.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.monitora.android.nufscar.R;
import com.monitora.android.nufscar.main.json.LoadJSONNoticias;
import com.monitora.android.nufscar.model.News;
import com.monitora.android.nufscar.view.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vdour on 26/01/2017.
 */

public class NewsFeedFragment extends Fragment implements LoadJSONNoticias.Listener, AdapterView.OnItemClickListener {
    private View newsFeedView;
    private List<HashMap<String, String>> mAndroidMapList;

    public static final String URL = "https://ufscar-monitora.firebaseio.com/.json";

    public static final String KEY_AUTOR = "autor";
    public static final String KEY_DATA = "data";
    public static final String KEY_FIGCAPTION = "figcapion";
    public static final String KEY_IDNOTICIA = "idNoticia";
    public static final String KEY_IMG = "image_src";
    public static final String KEY_TEXTO = "texto";
    public static final String KEY_TITULO = "titulo";
    public static final String KEY_URL = "url";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.newsFeedView = inflater.inflate(R.layout.news_feed_layout, container, false);
        mAndroidMapList = new ArrayList<>();

        new LoadJSONNoticias(this).execute(URL);

        return this.newsFeedView;
    }

    @Override
    public void onLoaded(List<News> androidList) {
        for (News android : androidList) {

            HashMap<String, String> map = new HashMap<>();

            map.put(KEY_AUTOR, android.getAutor());
            map.put(KEY_DATA, android.getData());
            map.put(KEY_FIGCAPTION, android.getFigcaption());
            map.put(KEY_IDNOTICIA, android.getIdNoticia());
            map.put(KEY_IMG, android.getImg_src());
            map.put(KEY_TEXTO, android.getTexo());
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

        ListView newsFeedListView = (ListView) this.newsFeedView.findViewById(R.id.list_view_news_feed);
        ListAdapter listAdapter = new ListAdapter(this.mAndroidMapList);
        newsFeedListView.setAdapter(listAdapter);

    }
}
