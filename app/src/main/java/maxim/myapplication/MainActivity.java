package maxim.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainLOG";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        requestJsonObject();
    }
    private void requestJsonObject(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://newsapi.org/v1/articles?source=techcrunch&apiKey=b03232861d6441aca99bed4a19d95e8b";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response " + response);
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                List<ItemObject> posts = new ArrayList<>();
                JSONObject json;
                JSONArray jsonArray;
                try {
                    json=new JSONObject(response);
                    jsonArray=json.getJSONArray("articles");
                    posts = Arrays.asList(mGson.fromJson(jsonArray.toString(), ItemObject[].class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                adapter = new RecyclerViewAdapter(MainActivity.this, posts);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error " + error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}