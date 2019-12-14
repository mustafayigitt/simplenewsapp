package com.example.haberler.ui.technology;

import androidx.lifecycle.ViewModel;

import com.example.haberler.model.ModelNew;

import java.util.ArrayList;

public class TechnologyViewModel extends ViewModel {

    private ArrayList<ModelNew> newsList;

    public TechnologyViewModel() {
        //  GetNews getNews = new GetNews(getContext(), recyclerView, "sport");
        // getNews.execute();
    }

    public ArrayList<ModelNew> getNewsList() {
        return newsList;
    }

}