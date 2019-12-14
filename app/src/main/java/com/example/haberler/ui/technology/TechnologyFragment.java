package com.example.haberler.ui.technology;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.haberler.R;
import com.example.haberler.model.GetNews;

public class TechnologyFragment extends Fragment {

    private TechnologyViewModel technologyViewModel;
    static RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        technologyViewModel = ViewModelProviders.of(this).get(TechnologyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_technology, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        swipeRefreshLayout = root.findViewById(R.id.simpleSwipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        GetNews getNews = new GetNews(getContext(),recyclerView,"sport");
                        getNews.execute();
                    }
                }, 3000);
            }
        });


        GetNews getNews = new GetNews(getContext(),recyclerView,"technology");
        getNews.execute();

        return root;
    }
}