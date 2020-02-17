package com.example.haberler.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.haberler.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

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

    public void updateData(ArrayList<ModelNew> modelNews){
        this.modelNews = modelNews;
        notifyDataSetChanged();
    }

    class CustomHolder extends RecyclerView.ViewHolder {

        private TextView headerTxt;
        private TextView contentTxt;
        private ImageView imageView;
        private TextView sourceUrlTxt;

        public CustomHolder(@NonNull final View itemView) {
            super(itemView);

            headerTxt = itemView.findViewById(R.id.textView1);
            contentTxt = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
            sourceUrlTxt = itemView.findViewById(R.id.textView3);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sourceUrlTxt.getText().toString()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });
        }

        public void setData(ModelNew selectedModelNew, int position){
            String header = selectedModelNew.getHeader();
            String content = selectedModelNew.getContent();
            String imageUrl = selectedModelNew.getImage();
            String sourceUrl = selectedModelNew.getSourceUrl();

            headerTxt.setText(header);
            contentTxt.setText(content);
            sourceUrlTxt.setText(sourceUrl);
            if (!imageUrl.isEmpty()) {
                Picasso.get().load(imageUrl).into(imageView);
            }
        }

    }
}
