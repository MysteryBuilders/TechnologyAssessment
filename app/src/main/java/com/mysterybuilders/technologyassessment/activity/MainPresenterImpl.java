package com.mysterybuilders.technologyassessment.activity;


import com.mysterybuilders.technologyassessment.model.News;

import java.util.ArrayList;

/**
 * Created by bpn on 12/7/17.
 */

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetNewsIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetNewsIntractor getNewsIntractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetNewsIntractor getNewsIntractor) {
        this.mainView = mainView;
        this.getNewsIntractor = getNewsIntractor;
    }

    @Override
    public void onDestroy() {

        mainView = null;

    }

    @Override
    public void onRefreshButtonClick() {

        if(mainView != null){
            mainView.showProgress();
        }
        getNewsIntractor.getNewsArrayList(this);

    }

    @Override
    public void requestDataFromServer() {
        getNewsIntractor.getNewsArrayList(this);
    }


    @Override
    public void onFinished(ArrayList<News> newsArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(newsArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
