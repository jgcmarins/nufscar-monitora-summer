package com.monitora.android.nufscar.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.monitora.android.nufscar.R;
import com.monitora.android.nufscar.model.Eventos;
import com.monitora.android.nufscar.view.fragment.EventsFragment;

import org.w3c.dom.Text;

public class EventsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_details);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Eventos event = (Eventos) extras.getSerializable(EventsFragment.KEY_IDEVENTO);

            TextView eventsTitle = (TextView) findViewById(R.id.events_details_title);
            TextView eventsHost = (TextView) findViewById(R.id.events_details_host);
            TextView eventsDate = (TextView) findViewById(R.id.events_details_date);
            TextView eventsText = (TextView) findViewById(R.id.events_details_text);

            eventsTitle.setText(event.getTitulo());
            eventsDate.setText("Data do evento: " + event.getData());
            eventsHost.setText(event.getLocal());
            eventsText.setText(event.getTexto());
        }
    }
}
