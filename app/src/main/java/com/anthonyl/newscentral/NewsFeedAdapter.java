package com.anthonyl.newscentral;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedViewHolder> {

    List<NewsItem> list;

    public NewsFeedAdapter(List<NewsItem> list) {
        this.list = list;
    }

    @Override
    public NewsFeedViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item_view,viewGroup,false);
        return new NewsFeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsFeedViewHolder viewholder, int position) {
        NewsItem item = list.get(position);
        viewholder.bind(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
