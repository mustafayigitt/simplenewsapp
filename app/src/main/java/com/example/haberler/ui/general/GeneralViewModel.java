package com.example.haberler.ui.general;

import androidx.lifecycle.ViewModel;

import com.example.haberler.model.ModelNew;

import java.util.ArrayList;

public class GeneralViewModel extends ViewModel {

    private ArrayList<ModelNew> newsList;

    public GeneralViewModel() {
        //  GetNews getNews = new GetNews(getContext(), recyclerView, "sport");
        // getNews.execute();
    }

    public ArrayList<ModelNew> getNewsList() {
        return newsList;
    }
}