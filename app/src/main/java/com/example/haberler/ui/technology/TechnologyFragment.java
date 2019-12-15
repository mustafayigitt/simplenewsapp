package com.example.haberler.ui.technology;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.haberler.IPrepareRecyler;
import com.example.haberler.MainActivity;
import com.example.haberler.R;
import com.example.haberler.model.CustomAdapter;
import com.example.haberler.model.GetNews;
import com.example.haberler.model.ModelNew;

import java.util.ArrayList;

public class TechnologyFragment extends Fragment implements IPrepareRecyler, SwipeRefreshLayout.OnRefreshListener {

    private TechnologyViewModel technologyViewModel;
    static RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<ModelNew> news;
    private CustomAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        technologyViewModel = ViewModelProviders.of(this).get(TechnologyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_technology, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        swipeRefreshLayout = root.findViewById(R.id.simpleSwipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(this);


        GetNews getNews = new GetNews(TechnologyFragment.this,"technology");
        getNews.execute();

        return root;
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ((MainActivity) getActivity()).search(adapter, news, newText);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                GetNews getNews = new GetNews(TechnologyFragment.this, "technology");
                getNews.execute();
            }
        }, 3000);
    }

    @Override
    public void prepareRecycler(ArrayList<ModelNew> news) {
        this.news = news;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CustomAdapter(getContext(), news);
        recyclerView.setAdapter(adapter);
    }
}

