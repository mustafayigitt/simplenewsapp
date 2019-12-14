package com.example.haberler.ui.economy;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.haberler.R;
import com.example.haberler.model.GetNews;

public class EconomyFragment extends Fragment {

    private EconomyViewModel economyViewModel;
    static RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        economyViewModel = ViewModelProviders.of(this).get(EconomyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_economy, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        swipeRefreshLayout = root.findViewById(R.id.simpleSwipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // implement Handler to wait for 3 seconds and then update UI means update value of TextView
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        GetNews getNews = new GetNews(getContext(),recyclerView,"economy");
                        getNews.execute();
                    }
                }, 3000);
            }
        });

        GetNews getNews = new GetNews(getContext(),recyclerView,"economy");
        getNews.execute();

        return root;
    }
}