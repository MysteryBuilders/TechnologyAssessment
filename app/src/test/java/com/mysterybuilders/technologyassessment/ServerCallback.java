package com.mysterybuilders.technologyassessment;

public interface ServerCallback {
    // Api detect connection
    void onSuccess(int statusCode, String response);
    void onFailure(int statusCode, String response);
}
