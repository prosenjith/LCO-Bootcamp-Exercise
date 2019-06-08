package com.studycseathome.jsonandapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.studycseathome.jsonandapi.Adapter.MyAdapter;
import com.studycseathome.jsonandapi.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<User> list;
    private String URL_Data="https://api.github.com/users";
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyler_view_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        loadUrl();
    }

    private void loadUrl() {
        JsonArrayRequest stringRequest=new JsonArrayRequest(URL_Data,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        getValue(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
    public void getValue(JSONArray array){
        for(int i=0;i<array.length();i++) {
            User user=new User();
            JSONObject json=null;
            try{
                json=array.getJSONObject(i);
                user.setLogin(json.getString("login"));
                user.setAvatarUrl(json.getString("avatar_url"));
        }catch (JSONException e){
                e.printStackTrace();
            }
            list.add(user);

    }
        adapter=new MyAdapter(list,this);
        recyclerView.setAdapter(adapter);
}
}

