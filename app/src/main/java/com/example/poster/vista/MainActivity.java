package com.example.poster.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.poster.R;
import com.example.poster.modelo.JsonApi;
import com.example.poster.modelo.PostDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    ArrayList<PostDataModel> postModel;
    private AdapterPostList adapterPostList;
    private RecyclerView post_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        post_recyclerview = findViewById(R.id.recycler);
        post_recyclerview.setLayoutManager(new LinearLayoutManager(this));


        getPosts();


    }

    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonApi jsonApi = retrofit.create(JsonApi.class);
        Call<List<PostDataModel>> call = jsonApi.getPostData();
        call.enqueue(new Callback<List<PostDataModel>>() {
            @Override
            public void onResponse(Call<List<PostDataModel>> call, Response<List<PostDataModel>> response) {

                if (response.isSuccessful()) {

                    postModel = new ArrayList<>(response.body());
                    adapterPostList = new AdapterPostList(MainActivity.this, postModel);
                    post_recyclerview.setAdapter(adapterPostList);

                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                    return;
                }

            }

            @Override
            public void onFailure(Call<List<PostDataModel>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void OnclickAll(View view){

    }

    public void OnclickFavorito(View view){

    }


}
