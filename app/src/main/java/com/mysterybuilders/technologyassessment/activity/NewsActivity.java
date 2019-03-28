package com.mysterybuilders.technologyassessment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mysterybuilders.technologyassessment.R;
import com.mysterybuilders.technologyassessment.model.CustomParcable;
import com.mysterybuilders.technologyassessment.model.News;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity implements NewsDetailsContract.NewsView

        {
            private NewsDetailsContract.presenter presenter;
            TextView titleTextView, authorTextView;
            ImageView newsImageView;
            ProgressBar loading;
            CustomParcable customParcable;
            String title;
            String author;
            String date;
            String imageUrl;
            DisplayImageOptions options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        titleTextView = findViewById(R.id.title_text_view);
        authorTextView = findViewById(R.id.author_text_view);

        newsImageView =findViewById(R.id.profile_image);
        loading= findViewById(R.id.loading);
        options = new DisplayImageOptions.Builder()

                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)

                .displayer(new SimpleBitmapDisplayer())
                .build();
        presenter = new NewsPresenterImpl(NewsActivity.this);
        customParcable = getIntent().getParcelableExtra("data");
        title = customParcable.get("title");
        author = customParcable.get("author");
        date = customParcable.get("date");
        imageUrl = customParcable.get("imageUrl");
        titleTextView.setText(title);
        authorTextView.setText(author);
        ImageLoader.getInstance().displayImage(imageUrl, newsImageView, options,
                new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {

                       presenter.onStartLoadingImage();


                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view,
                                                FailReason failReason) {

                        presenter.onEndLoadingImage();


                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view,
                                                  Bitmap loadedImage) {
                        presenter.onEndLoadingImage();


                    }

                });





    }




            @Override
            protected void onDestroy() {
                super.onDestroy();
                presenter.onDestroy();
            }


            @Override
            public void showProgress() {
                loading.setVisibility(View.VISIBLE);
            }

            @Override
            public void hideProgress() {
        loading.setVisibility(View.GONE);

            }
        }
