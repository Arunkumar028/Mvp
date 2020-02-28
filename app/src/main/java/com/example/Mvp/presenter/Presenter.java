package com.example.Mvp.presenter;

import android.content.Context;

import com.example.Mvp.activity.MainActivity;
import com.example.Mvp.model.Responcedetails;
import com.example.Mvp.mvp.Mvp;
import com.example.Mvp.service.Apiclient;
import com.example.Mvp.service.Apiinteface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements Mvp.main {

    Context mcontext;
    Mvp.mainactity mainactity;

    public Presenter(MainActivity mainActivity, MainActivity mainActivity1) {
        this.mainactity=mainActivity1;
        this.mcontext=mainActivity;
    }

    @Override
    public void main() {
        Apiinteface apiinteface= Apiclient.getClient().create(Apiinteface.class);
        Call<List<Responcedetails>> call=apiinteface.getresponce();
        call.enqueue(new Callback<List<Responcedetails>>() {
            @Override
            public void onResponse(Call<List<Responcedetails>> call, Response<List<Responcedetails>> response) {
                if (response.isSuccessful()){
                    mainactity.success((List<Responcedetails>)response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Responcedetails>> call, Throwable t) {
                if (t instanceof Exception){
                    mainactity.fail("Code error");
                }
                else {
                    mainactity.fail("Internet connection error");
                }

            }
        });


    }
}
