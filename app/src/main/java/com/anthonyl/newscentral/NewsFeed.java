package com.anthonyl.newscentral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewsFeed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        getNews();
    }

    /*void getNews() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/posts";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    mTextView.setText("Response is: "+ response.substring(0,500));
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    mTextView.setText(error.toString());
                }
            }
        );
        queue.add(stringRequest);
    }*/

    void getNews() {
        final TextView mTextView = findViewById(R.id.news);
        RequestQueue queue = Volley.newRequestQueue(this);

        String url ="http://jsonplaceholder.typicode.com/posts?userId=1";
        JsonArrayRequest newsReq = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        String newsDisplay = "";
                        for(int i=0;i<response.length();i++) {
                            JSONObject newsObj = null;
                            try {
                                newsObj = response.getJSONObject(i);
                                String title = newsObj.getString("title");
                                String body = newsObj.getString("body");

                                newsDisplay += "Title: "+title+"\nBody: "+body+"\n\n";
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        mTextView.setText(newsDisplay);
                        mTextView.setMovementMethod(new ScrollingMovementMethod());
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
}
