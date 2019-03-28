package com.mysterybuilders.technologyassessment;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mysterybuilders.technologyassessment.applicationHelper.Constants;

import okhttp3.internal.http2.Header;

public class TestHttpClient {
    static AsyncHttpClient client = new AsyncHttpClient();
    // package-local baseUrl that can be set in tests
    static String baseUrl = Constants.Extra.BASE_URL;

    public static void getData(final ServerCallback callback) {
        String url = baseUrl + "emailed/7.json?api-key=rRpJAOa3N8mGyAxGRygDAGpmt84ESyW4";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                callback.onSuccess(statusCode, new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                callback.onFailure(statusCode, new String(responseBody));
            }


        });
    }
}
