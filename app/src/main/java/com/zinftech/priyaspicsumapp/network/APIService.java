package com.zinftech.priyaspicsumapp.network;

import com.zinftech.priyaspicsumapp.model.AuthorModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService
{
    @GET("list")
    Call<List<AuthorModel>> getAuthorList();
}
