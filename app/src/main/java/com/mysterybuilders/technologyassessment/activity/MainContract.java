package com.mysterybuilders.technologyassessment.activity;


import com.mysterybuilders.technologyassessment.model.News;

import java.util.ArrayList;

/**
 * Created by bpn on 12/6/17.
 */

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface presenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<News> newsArrayList);

        void onResponseFailure(Throwable throwable);


    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetNewsIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<News> newsArrayList);
            void onFailure(Throwable t);
        }

        void getNewsArrayList(OnFinishedListener onFinishedListener);
    }
}
