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
import android.widget.Toast;

import com.monitora.android.nufscar.R;
import com.monitora.android.nufscar.main.json.LoadJSONNoticias;
import com.monitora.android.nufscar.model.News;
import com.monitora.android.nufscar.view.NewsDetailsActivity;
import com.monitora.android.nufscar.view.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vdour on 26/01/2017.
 */

public class NewsFeedFragment extends Fragment implements LoadJSONNoticias.Listener, AdapterView.OnItemClickListener {
    private View newsFeedView;
    private List<News> mAndroidMapList;

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
        mAndroidMapList = new ArrayList<News>();

        new LoadJSONNoticias(this).execute(URL);

        return this.newsFeedView;
    }


    @Override
    public void onLoaded(List<News> androidList) {
        for (News android : androidList) {


            mAndroidMapList.add(android);
        }

        ListView listView = loadListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                News news = (News) parent.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), NewsDetailsActivity.class);
                intent.putExtra(KEY_IDNOTICIA,news);
                startActivity(intent);


            }
        });

    }

    @Override
    public void onError() {
        //Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
    }



    private ListView  loadListView() {

        /*ListAdapter adapter = new SimpleAdapter(NewsFeedFragment.this, mAndroidMapList, R.layout.list_item,
                new String[] {  KEY_TITULO, KEY_IMG, KEY_IDNOTICIA },
                new int[] {R.id.version,R.id.name, R.id.api });*/

        //mListView.setAdapter(adapter);

        ListView newsFeedListView = (ListView) this.newsFeedView.findViewById(R.id.list_view_news_feed);
        ListAdapter listAdapter = new ListAdapter(this.mAndroidMapList);
        newsFeedListView.setAdapter(listAdapter);

        return newsFeedListView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
