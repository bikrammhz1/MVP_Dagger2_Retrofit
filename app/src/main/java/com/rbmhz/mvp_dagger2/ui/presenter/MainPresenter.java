package com.rbmhz.mvp_dagger2.ui.presenter;


import android.util.Log;

import com.google.gson.Gson;
import com.rbmhz.mvp_dagger2.di_init.component.NetworkInterface;
import com.rbmhz.mvp_dagger2.ui.model.MainInterface;
import com.rbmhz.mvp_dagger2.ui.model.Resp;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainInterface.presenter {

    @Inject
    NetworkInterface apiService;

    MainInterface.view  view;

    public MainPresenter(MainInterface.view view, NetworkInterface apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void callApi() {
        apiService.getDatas().enqueue(new Callback<ArrayList<Resp.data>>() {
            @Override
            public void onResponse(Call<ArrayList<Resp.data>> call, Response<ArrayList<Resp.data>> response) {
                view.responseData(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Resp.data>> call, Throwable t) {
                Log.d("onFailure==>", t.getMessage());
            }
        });
    }
}
