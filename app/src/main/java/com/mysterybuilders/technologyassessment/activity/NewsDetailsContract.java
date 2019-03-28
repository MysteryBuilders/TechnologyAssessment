package com.mysterybuilders.technologyassessment.activity;

import com.mysterybuilders.technologyassessment.model.News;

import java.util.ArrayList;

public interface NewsDetailsContract {

    interface presenter{

        void onDestroy();
        void onStartLoadingImage();
        void onEndLoadingImage();





    }
    interface NewsView {

        void showProgress();

        void hideProgress();




    }
}
