package com.example.kristian.stressfree.Presenters;

import com.example.kristian.stressfree.Views.MindfulnessActivity;

public class MindfulnessPresenter {

    private MindfulnessPresenter.Context view;
    private String[] mindfullList, mindfullThumbnail;

    public MindfulnessPresenter(MindfulnessActivity view){
        //this.view = view;

        mindfullList = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FVideos%2FForest_video.mov?alt=media&token=8d031179-0d13-469c-a9b3-0f48d9e0d15c",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FVideos%2FWaterfall_video.mp4?alt=media&token=f86b77b0-ccbb-4ad2-9375-321fd4d7abca"
        };

        mindfullThumbnail = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FThumbnails%2FForest_thumbnail.PNG?alt=media&token=c4eb9f4f-8e69-49e2-b64b-21b78f37dfb9",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FThumbnails%2FWaterfall_thumbnail.PNG?alt=media&token=78921c5e-3871-4d16-a4fd-bacb92e3ae83"
        };

    }

    public String[] getMindfullList() {
        return mindfullList;
    }

    public String[] getMindfullThumbnail() {
        return mindfullThumbnail;
    }

    // Interface to the methods in MyStressFree
    public interface Context {

    }
}
