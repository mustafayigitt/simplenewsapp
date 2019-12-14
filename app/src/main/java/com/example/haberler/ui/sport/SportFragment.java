package com.example.haberler.ui.sport;

import android.os.Bundle;
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

import com.example.haberler.R;
import com.example.haberler.model.GetNews;

public class SportFragment extends Fragment {

    private SportViewModel sportViewModel;
    static RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sportViewModel = ViewModelProviders.of(this).get(SportViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sport, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        GetNews getNews = new GetNews(getContext(),recyclerView,"sport");
        getNews.execute();


        return root;
    }
}