package com.example.kristian.stressfree.Utilities;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.MediaController;

public class MyMediaController extends MediaController {

    private MediaController mediaPlayer;

    public MyMediaController(Context context, AttributeSet attrs, MediaController mediaPlayer) {
        super(context, attrs);
        this.mediaPlayer = mediaPlayer;
    }

    public MyMediaController(Context context, boolean useFastForward) {
        super(context, useFastForward);
    }

    public MyMediaController(Context context) {
        super(context);
    }

    @Override
    public void show(int timeout) {
        super.show(0);
    }


}