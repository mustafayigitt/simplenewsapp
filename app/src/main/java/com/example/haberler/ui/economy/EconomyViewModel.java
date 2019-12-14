package com.example.haberler.ui.economy;


import androidx.lifecycle.ViewModel;
import com.example.haberler.model.ModelNew;

import java.util.ArrayList;

public class EconomyViewModel extends ViewModel {

    private ArrayList<ModelNew> newsList;

    public EconomyViewModel() {
      //  GetNews getNews = new GetNews(getContext(), recyclerView, "sport");
       // getNews.execute();
    }

    public ArrayList<ModelNew> getNewsList() {
        return newsList;
    }

}