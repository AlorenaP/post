package com.example.poster.modelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {

    //metodo que se encarga de hacer el llamado a la informacion remota

    @GET("posts")
    Call<List<PostDataModel>> getPostData();
}
