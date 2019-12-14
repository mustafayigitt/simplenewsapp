package com.example.haberler.ui.technology;

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

public class TechnologyFragment extends Fragment {

    private TechnologyViewModel technologyViewModel;
    static RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        technologyViewModel = ViewModelProviders.of(this).get(TechnologyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_technology, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        GetNews getNews = new GetNews(getContext(),recyclerView,"technology");
        getNews.execute();

        return root;
    }
}