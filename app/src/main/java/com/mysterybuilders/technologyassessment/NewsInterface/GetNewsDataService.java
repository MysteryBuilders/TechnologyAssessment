package com.mysterybuilders.technologyassessment.NewsInterface;


import com.mysterybuilders.technologyassessment.model.NewsList;



import retrofit2.Call;

import retrofit2.http.GET;


public interface GetNewsDataService {

    @GET("emailed/7.json?api-key=rRpJAOa3N8mGyAxGRygDAGpmt84ESyW4")
    Call<NewsList> getNewsData();





}