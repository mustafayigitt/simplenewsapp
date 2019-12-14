package com.example.haberler.ui.economy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.haberler.R;
import com.example.haberler.model.GetNews;

public class EconomyFragment extends Fragment {

    private EconomyViewModel economyViewModel;
    static RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        economyViewModel = ViewModelProviders.of(this).get(EconomyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_econmy, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        GetNews getNews = new GetNews(getContext(),recyclerView,"economy");
        getNews.execute();

        return root;
    }
}