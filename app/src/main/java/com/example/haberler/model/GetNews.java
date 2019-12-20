package com.example.haberler.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.haberler.IPrepareRecyler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class GetNews extends AsyncTask<String, Void, String> {

    String result;
    URL url;
    HttpURLConnection httpURLConnection;
    InputStream stream;
    InputStreamReader reader;

    ArrayList<ModelNew> news;
    IPrepareRecyler iPrepareRecyler;

    String targetCategory;
    Context context;

    public GetNews(IPrepareRecyler iPrepareRecyler,String targetCategory) {
        this.iPrepareRecyler = iPrepareRecyler;
        this.targetCategory = targetCategory;
    }


    @Override
    protected String doInBackground(String... strings) {

        try {
            result = "";
            url = new URL("https://api.collectapi.com/news/getNews?tag="+targetCategory+"&country=tr");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.addRequestProperty("Authorization","YOUR APIKEY");
            stream = httpURLConnection.getInputStream();
            reader = new InputStreamReader(stream);

            int data = reader.read();
            while (data > 0){
                char ch = (char) data;
                result += ch;
                data = reader.read();
            }

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject fullData = new JSONObject(s);
            JSONArray rs = fullData.getJSONArray("result");

            news = new ArrayList<>();

            for (int i = 0; i < rs.length(); i++) {
                JSONObject obj;
                obj = rs.getJSONObject(i);
                String header = obj.getString("name");
                String content = obj.getString("description");
                String image = obj.getString("image");
                System.out.println("Header: " + header + " Content: " + content + "URL: " + image);
                System.out.println();

                news.add(new ModelNew(content,header,image));
            }

            iPrepareRecyler.prepareRecycler(news);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
