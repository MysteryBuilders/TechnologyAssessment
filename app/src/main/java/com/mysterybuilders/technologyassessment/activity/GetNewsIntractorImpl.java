package com.mysterybuilders.technologyassessment.activity;

import android.util.Log;


import com.mysterybuilders.technologyassessment.NewsInterface.GetNewsDataService;
import com.mysterybuilders.technologyassessment.model.News;
import com.mysterybuilders.technologyassessment.model.NewsList;
import com.mysterybuilders.technologyassessment.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bpn on 12/7/17.
 */

public class GetNewsIntractorImpl implements MainContract.GetNewsIntractor {

    @Override
    public void getNewsArrayList(final OnFinishedListener onFinishedListener) {


        /** Create handle for the RetrofitInstance interface*/
        GetNewsDataService service = RetrofitInstance.getRetrofitInstance().create(GetNewsDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<NewsList> call = service.getNewsData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                onFinishedListener.onFinished(response.body().getNewsList());

            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
