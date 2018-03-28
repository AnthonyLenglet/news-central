package com.anthonyl.newscentral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsFeed extends AppCompatActivity {

    private List<NewsItem> newsItems = new ArrayList<>();
    private RecyclerView NewsFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        NewsFeed = findViewById(R.id.NewsFeed);

        getNews();
    }

    void getNews() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url ="https://newsapi.org/v2/top-headlines?country=fr&apiKey=fa75c35a4b9b485e816170a0bd08d85d";
        JsonObjectRequest newsReq = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        parseNewsItems(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.wtf("JSON", error.toString());
                    }
                }
        );
        queue.add(newsReq);
    }

    void parseNewsItems(JSONObject jsonObj) {
        JSONArray articlesList = null;
        try {
            articlesList = jsonObj.getJSONArray("articles");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int i=0;i<articlesList.length();i++) {
            try {
                JSONObject article = articlesList.getJSONObject(i);
                String title = article.getString("title");
                String body = article.getString("description");
                String image = article.getString("urlToImage");
                newsItems.add(new NewsItem(title, body, image));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        /*for(int i=0;i<jsonArr.length();i++) {
            JSONObject newsObj = null;
            try {
                newsObj = jsonArr.getJSONObject(i);
                String title = newsObj.getString("title");
                String body = newsObj.getString("body");
                String image = "https://imagejournal.org/wp-content/uploads/bb-plugin/cache/23466317216_b99485ba14_o-panorama.jpg";//newsObj.getString("image");

                newsItems.add(new NewsItem(title, body, image));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }*/
        createFeed();
    }

    void createFeed() {
        NewsFeed.setLayoutManager(new LinearLayoutManager(this));
        NewsFeed.setAdapter(new NewsFeedAdapter(newsItems));
    }
}
