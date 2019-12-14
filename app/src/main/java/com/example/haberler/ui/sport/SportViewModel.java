package com.example.haberler.ui.sport;


import androidx.lifecycle.ViewModel;

import com.example.haberler.model.ModelNew;

import java.util.ArrayList;

public class SportViewModel extends ViewModel {

    private ArrayList<ModelNew> newsList;

    public SportViewModel() {
        //  GetNews getNews = new GetNews(getContext(), recyclerView, "sport");
        // getNews.execute();
    }

    public ArrayList<ModelNew> getNewsList() {
        return newsList;
    }
}