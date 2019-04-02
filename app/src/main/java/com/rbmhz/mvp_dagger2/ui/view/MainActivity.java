package com.rbmhz.mvp_dagger2.ui.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rbmhz.mvp_dagger2.R;
import com.rbmhz.mvp_dagger2.helper.App;
import com.rbmhz.mvp_dagger2.ui.di.MainComponent;
import com.rbmhz.mvp_dagger2.ui.di.MainModule;
import com.rbmhz.mvp_dagger2.ui.model.MainInterface;
import com.rbmhz.mvp_dagger2.ui.model.Resp;
import com.rbmhz.mvp_dagger2.ui.presenter.MainPresenter;
import com.rbmhz.mvp_dagger2.ui.view.adapter.recycleView;
import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainInterface.view{

    @Inject
    MainPresenter mainPresenter;

    MainComponent mainComponent;

    private recycleView mAdapter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mainPresenter.callApi();
    }

    private void init(){
        mainComponent =  ((App) getApplication()).get(this).getNetComponent()
                .add(new MainModule(this));
        mainComponent.inject(this);

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
    }

    @Override
    public void responseData(ArrayList<Resp.data> data) {
        mAdapter = new recycleView(data);
        rv.setAdapter(mAdapter);
    }
}
