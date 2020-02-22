package com.example.retrofitexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        JsonPlaceholder jsonPlaceholder = RetrofitSingleTon.getInstance().create(JsonPlaceholder.class);
        Call<List<Post>> call = jsonPlaceholder.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Log.d("data", "" + response.body());
                }
                generateList(response.body());
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Nhi Hua !!", Toast.LENGTH_SHORT)
                        .show();
                Log.d("Fail", "onFailure: " + t.getMessage());
            }
        });
    }
    public void generateList(List<Post> posts) {
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter recyclerAdapter = new recyclerAdapter(posts, this);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
