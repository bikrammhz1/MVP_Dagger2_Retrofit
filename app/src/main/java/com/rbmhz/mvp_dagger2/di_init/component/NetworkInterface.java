package com.rbmhz.mvp_dagger2.di_init.component;

import com.rbmhz.mvp_dagger2.di_init.scope.Application;
import com.rbmhz.mvp_dagger2.ui.model.Resp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

@Application
public interface NetworkInterface {

    @GET("albums")
    Call<ArrayList<Resp.data>> getDatas();

}
