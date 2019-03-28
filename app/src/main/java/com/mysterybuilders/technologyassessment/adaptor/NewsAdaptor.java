package com.mysterybuilders.technologyassessment.adaptor;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mysterybuilders.technologyassessment.R;
import com.mysterybuilders.technologyassessment.activity.RecyclerItemClickListener;
import com.mysterybuilders.technologyassessment.model.Image;
import com.mysterybuilders.technologyassessment.model.MediaList;
import com.mysterybuilders.technologyassessment.model.News;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdaptor extends RecyclerView.Adapter<NewsAdaptor.EmployeeViewHolder> {

    private ArrayList<News> dataList;
    private RecyclerItemClickListener recyclerItemClickListener;
    DisplayImageOptions options;

    public NewsAdaptor(ArrayList<News> dataList, RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
        options = new DisplayImageOptions.Builder()

                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)

                .displayer(new CircleBitmapDisplayer())
                .build();
    }


    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.titleTextView.setText(dataList.get(position).getTitle());
        holder.authorTextView.setText(dataList.get(position).getAuthor());
        holder.dateTextView.setText(dataList.get(position).getPublishedDate());
String  imageUrl = dataList.get(position).getMediaList().get(0).getImageList().get(2).getImageUrl();


        ;if (position == dataList.size() / 2 /* calculate middle element position */) {
            holder.setIsInTheMiddle(true);
               } else {
            holder.setIsInTheMiddle(false);

        }
        ImageLoader.getInstance().displayImage(imageUrl, holder.newsImageView, options,
                new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {

                        holder.loading.setVisibility(View.VISIBLE);


                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view,
                                                FailReason failReason) {

                        holder.loading.setVisibility(View.GONE);


                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view,
                                                  Bitmap loadedImage) {
                        holder.loading.setVisibility(View.GONE);


                    }

                });
        holder.setIsRecyclable(false);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

  public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
      private boolean mIsInTheMiddle = false;
        TextView titleTextView, authorTextView, dateTextView;
        AppCompatImageView newsImageView;
        ProgressBar loading;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            authorTextView = itemView.findViewById(R.id.author_text_view);
            dateTextView = itemView.findViewById(R.id.date_text_view);
            newsImageView = itemView.findViewById(R.id.profile_image);
            loading= itemView.findViewById(R.id.loading);

        }
      public boolean getIsInTheMiddle() {
          return mIsInTheMiddle;
      }

      void setIsInTheMiddle(boolean isInTheMiddle) {
          mIsInTheMiddle = isInTheMiddle;
      }
    }
}
