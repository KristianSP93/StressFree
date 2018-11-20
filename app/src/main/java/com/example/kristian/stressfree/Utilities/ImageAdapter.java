package com.example.kristian.stressfree.Utilities;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private String[] PicArray;

    public ImageAdapter(Context c, String[] array) {
        mContext = c;
        PicArray = array;
    }

    public int getCount() {
        return PicArray.length;
    }

    public Object getItem(int position) {

        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(333, 333));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        Glide.with(mContext)
                .load(PicArray[position])
                .into(imageView);

        return imageView;
    }
}
