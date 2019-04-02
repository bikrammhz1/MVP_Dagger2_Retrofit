package com.rbmhz.mvp_dagger2.ui.di;

import com.rbmhz.mvp_dagger2.di_init.scope.Activity;
import com.rbmhz.mvp_dagger2.ui.view.MainActivity;

import dagger.Subcomponent;

@Activity
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
