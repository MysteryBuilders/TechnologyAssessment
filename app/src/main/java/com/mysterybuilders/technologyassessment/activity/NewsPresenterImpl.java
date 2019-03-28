package com.mysterybuilders.technologyassessment.activity;

import com.mysterybuilders.technologyassessment.model.News;

import java.util.ArrayList;

public class NewsPresenterImpl implements NewsDetailsContract.presenter
        {

    private NewsActivity mainView;


    public NewsPresenterImpl(NewsActivity mainView) {
        this.mainView = mainView;

    }

    @Override
    public void onDestroy() {

        mainView = null;

    }

            @Override
            public void onStartLoadingImage() {
        mainView.showProgress();

            }

            @Override
            public void onEndLoadingImage() {
        mainView.hideProgress();

            }


        }
