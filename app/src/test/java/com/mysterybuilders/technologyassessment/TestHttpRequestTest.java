package com.mysterybuilders.technologyassessment;

import android.os.Build;

import com.loopj.android.http.SyncHttpClient;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = Build.VERSION_CODES.LOLLIPOP)
public class TestHttpRequestTest {

    @Rule
    public MockWebServer mockWebServer = new MockWebServer();

    @Test
    public void getData_onSuccess_doesSomething() throws InterruptedException {
        // Here we are creating a mock ServerCallback.  We will use
        // this mock object to verify the callback is invoked
        ServerCallback callback = mock(ServerCallback.class);

        // To test the client, we need to send a request to the mock mockWebServer.
        // The MockWebServer spins up an actual backend to handle calls.  You MUST
        // setup the client to use the base Url of the mockWebServer instead of

        TestHttpClient.baseUrl = mockWebServer.url("/").toString();

        // For testing, use a synchronous client so that we can get the response before
        // the test completes.
        TestHttpClient.client = new SyncHttpClient();

        // Set up the mockWebServer to return a MockResponse with
        // some data in the body. This data can be whatever you want... json, xml, etc.
        // The default response code is 200.
        mockWebServer.enqueue(new MockResponse().setBody("success"));
        // To simulate an error
//        mockWebServer.enqueue(new MockResponse().setResponseCode(500).setBody("error"));

        TestHttpClient.getData(callback); // calling the method under test

        verify(callback).onSuccess(200, "success"); // using verify of mockito
    }
}