package com.anthonyl.newscentral;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsFeedViewHolder extends RecyclerView.ViewHolder {

    private String url;
    private TextView title;
    private TextView article_info;
    private TextView bodyPreview;
    private ImageView image;

    public NewsFeedViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Log.i("CLICK", "onClick " + url);
            }
        });

        title = itemView.findViewById(R.id.title);
        article_info = itemView.findViewById(R.id.articleInfo);
        bodyPreview = itemView.findViewById(R.id.bodyPreview);
        image = itemView.findViewById(R.id.image);
    }

    public void bind(NewsItem News){
        url = News.getUrl();
        title.setText(News.getTitle());
        article_info.setText(News.getArticleInfo());
        bodyPreview.setText(News.getBodyPreview());
        Picasso.with(image.getContext()).load(News.getImage()).centerCrop().fit().into(image);
    }
}
