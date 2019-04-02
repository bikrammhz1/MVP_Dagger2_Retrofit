package com.rbmhz.mvp_dagger2.di_init.component;

import com.rbmhz.mvp_dagger2.di_init.module.ApiModule;
import com.rbmhz.mvp_dagger2.di_init.scope.Application;
import com.rbmhz.mvp_dagger2.ui.di.MainComponent;
import com.rbmhz.mvp_dagger2.ui.di.MainModule;


import dagger.Component;

@Application
@Component(modules = {
        ApiModule.class  //Adding api module services and provide other classes
})

public interface ApplicationComponent {
    MainComponent add(MainModule mainModule);
}
