package com.rbmhz.mvp_dagger2.ui.model;

import java.util.ArrayList;

public interface MainInterface {

    interface view{
        void responseData(ArrayList<Resp.data> data);
    }

    interface presenter{
        void callApi();
    }
}
