package com.monitora.android.nufscar.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.monitora.android.nufscar.R;
import com.monitora.android.nufscar.model.News;
import com.monitora.android.nufscar.view.fragment.NewsFeedFragment;

import java.util.HashMap;
import java.util.List;

/**
 * Created by vdour on 26/01/2017.
 */

public class ListAdapter extends BaseAdapter {

    private List<HashMap<String, String>> mAndroidMapList;

    public ListAdapter(List<HashMap<String, String>> mAndroidMapList) {
        this.mAndroidMapList = mAndroidMapList;
    }

    @Override
    public int getCount() {
        return mAndroidMapList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAndroidMapList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewInflater = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false);

        HashMap<String, String> news = this.mAndroidMapList.get(position);

        ContentViewHolder contentViewHolder = new ContentViewHolder(viewInflater);
        contentViewHolder.newsDate.setText(news.get(NewsFeedFragment.KEY_DATA));
        contentViewHolder.newsTitle.setText(news.get(NewsFeedFragment.KEY_TITULO));
        return viewInflater;
    }

    public class ContentViewHolder {
        protected TextView newsDate;
        protected TextView newsTitle;

        public ContentViewHolder(View view) {
            this.newsDate = (TextView) view.findViewById(R.id.text_view_news_date);
            this.newsTitle = (TextView) view.findViewById(R.id.text_view_news_title);
        }
    }

}
