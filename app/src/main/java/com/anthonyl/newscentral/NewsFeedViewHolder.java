package com.anthonyl.newscentral;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsFeedViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private String url;
    private TextView title;
    private TextView article_info;
    private TextView bodyPreview;
    private ImageView image;

    public NewsFeedViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener((View v) -> {
            Log.i("VIEW", "parent view on click is " + context);
            Log.i("CLICK", "onClick " + url);

            Intent intent = new Intent(context, NewsWebView.class);
            intent.putExtra("URL", url);
            context.startActivity(intent);
        });

        title = itemView.findViewById(R.id.title);
        article_info = itemView.findViewById(R.id.articleInfo);
        bodyPreview = itemView.findViewById(R.id.bodyPreview);
        image = itemView.findViewById(R.id.image);
    }

    public void bind(NewsItem News){
        context = News.getContext();
        url = News.getUrl();
        title.setText(News.getTitle());
        article_info.setText(News.getArticleInfo());
        bodyPreview.setText(News.getBodyPreview());
        Picasso.with(image.getContext()).load(News.getImage()).centerCrop().fit().into(image);
    }
}
