package com.example.Mvp.service;

import com.example.Mvp.model.Responcedetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiinteface {

    @GET("photos")
    Call<List<Responcedetails>> getresponce();

}
