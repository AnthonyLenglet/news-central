package com.anthonyl.newscentral;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsFeedViewHolder extends RecyclerView.ViewHolder{

    private TextView title;
    private TextView bodyPreview;
    private ImageView image;

    public NewsFeedViewHolder(View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        bodyPreview = itemView.findViewById(R.id.bodyPreview);
        image = itemView.findViewById(R.id.image);
    }

    public void bind(NewsItem News){
        title.setText(News.getTitle());
        bodyPreview.setText(News.getBodyPreview());
        Picasso.with(image.getContext()).load(News.getImage()).centerCrop().fit().into(image);
    }
}
