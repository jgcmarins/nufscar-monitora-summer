package com.monitora.android.nufscar.main.json;

/**
 * Created by Murilo on 25/01/2017.
 */

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.monitora.android.nufscar.model.Response;
import com.monitora.android.nufscar.model.Eventos;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LoadJSONEventos extends AsyncTask<String, Void, Response> {

    public LoadJSONEventos(Listener listener) {

        mListener = listener;
    }

    public interface Listener {

        void onLoaded(List<Eventos> androidList);

        void onError();
    }

    private Listener mListener;

    @Override
    protected Response doInBackground(String... strings) {
        try {

            String stringResponse = loadJSON(strings[0]);
            Gson gson = new Gson();

            return gson.fromJson(stringResponse, Response.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Response response) {

        if (response != null) {

            mListener.onLoaded(response.getAndroidEventos());

        } else {

            mListener.onError();
        }
    }

    private String loadJSON(String jsonURL) throws IOException {

        URL url = new URL(jsonURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = in.readLine()) != null) {

            response.append(line);
        }

        in.close();
        return response.toString();
    }
}