package com.example.haberler.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.haberler.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomHolder> {

    private ArrayList<ModelNew> modelNews;
    private LayoutInflater inflater;
    Context mContext;

    public CustomAdapter(Context context, ArrayList<ModelNew> modelNews){
        inflater = LayoutInflater.from(context);
        this.modelNews = modelNews;
        this.mContext = context;
    }


    @NonNull
    @Override
    public CustomAdapter.CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_item,parent,false);
        CustomHolder holder = new CustomHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomHolder holder, int position) {
        ModelNew selectedNews = modelNews.get(position);
        holder.setData(selectedNews,position);

    }

    @Override
    public int getItemCount() {
        //return modelNews.size();
        int a ;

        if(modelNews != null && !modelNews.isEmpty()) {

            a = modelNews.size();
        }
        else {

            a = 0;

        }

        return a;
    }

    class CustomHolder extends RecyclerView.ViewHolder {

        private TextView headerTxt;
        private TextView contentTxt;
        private ImageView imageView;

        public CustomHolder(@NonNull View itemView) {
            super(itemView);

            headerTxt = itemView.findViewById(R.id.textView1);
            contentTxt = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void setData(ModelNew selectedModelNew, int position){
            String header = selectedModelNew.getHeader();
            String content = selectedModelNew.getContent();
            String imageUrl = selectedModelNew.getImage();

            headerTxt.setText(header);
            contentTxt.setText(content);
            if (!imageUrl.isEmpty()) {
                Picasso.get().load(imageUrl).into(imageView);
            }
        }
    }
}
