package com.rbmhz.mvp_dagger2.ui.di;

import com.rbmhz.mvp_dagger2.di_init.component.NetworkInterface;
import com.rbmhz.mvp_dagger2.di_init.scope.Activity;
import com.rbmhz.mvp_dagger2.ui.model.MainInterface;
import com.rbmhz.mvp_dagger2.ui.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    public final MainInterface.view view;

    public MainModule(MainInterface.view view) {
        this.view = view;
    }

    @Activity
    @Provides
    MainInterface.view provideView() {
        return view;
    }

    @Activity
    @Provides
    MainPresenter providePresenter(MainInterface.view view, NetworkInterface networkInterface) {
        return new MainPresenter(view,networkInterface);
    }
}
