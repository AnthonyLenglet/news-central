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

        String url ="http://jsonplaceholder.typicode.com/posts?userId=1";
        JsonArrayRequest newsReq = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
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

    void parseNewsItems(JSONArray jsonArr) {
        for(int i=0;i<jsonArr.length();i++) {
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
        }
        createFeed();
    }

    void createFeed() {
        NewsFeed.setLayoutManager(new LinearLayoutManager(this));
        NewsFeed.setAdapter(new NewsFeedAdapter(newsItems));
    }
}
