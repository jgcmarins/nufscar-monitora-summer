package com.monitora.android.nufscar.view;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.monitora.android.nufscar.R;
import com.monitora.android.nufscar.model.News;
import com.monitora.android.nufscar.view.fragment.NewsFeedFragment;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class NewsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            News news = (News) extras.getSerializable(NewsFeedFragment.KEY_IDNOTICIA);


            TextView newsTitle = (TextView) findViewById(R.id.news_details_title);
            TextView newsAuthor = (TextView) findViewById(R.id.news_details_author);
            TextView newsText = (TextView) findViewById(R.id.news_details_text);
            ImageView targetImageView = (ImageView) findViewById(R.id.news_details_image);
            String imageUrl = news.getImg_src();

            Picasso
                    .with(this)
                    .load(imageUrl)
                    .into(targetImageView);



            newsTitle.setText(news.getTitulo());
            newsAuthor.setText(news.getAutor() + " - " +news.getData());
            newsText.setText(news.getTexto());




        }


    }

}
