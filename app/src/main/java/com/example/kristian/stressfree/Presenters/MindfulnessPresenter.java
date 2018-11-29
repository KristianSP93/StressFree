package com.example.kristian.stressfree.Presenters;

import com.example.kristian.stressfree.Views.MindfulnessActivity;

public class MindfulnessPresenter {

    private MindfulnessPresenter.Context view;
    private String[] mindfullList, mindfullThumbnail;

    public MindfulnessPresenter(MindfulnessActivity view){
        this.view = view;

        mindfullList = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FVideos%2FForest_video.mov?alt=media&token=8d031179-0d13-469c-a9b3-0f48d9e0d15c",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FVideos%2FWaterfall_video.mp4?alt=media&token=f86b77b0-ccbb-4ad2-9375-321fd4d7abca",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FVideos%2FWaterfall_video.mp4?alt=media&token=f86b77b0-ccbb-4ad2-9375-321fd4d7abca",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FVideos%2FWaterfall_video.mp4?alt=media&token=f86b77b0-ccbb-4ad2-9375-321fd4d7abca",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FVideos%2FWaterfall_video.mp4?alt=media&token=f86b77b0-ccbb-4ad2-9375-321fd4d7abca"
        };

        mindfullThumbnail = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/Mindfulness%2FThumbnails%2Fmindful_1.PNG?alt=media&token=56c65fbb-fa0f-454f-8c30-467a494079cd",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/Mindfulness%2FThumbnails%2Fmindful_2.PNG?alt=media&token=ed057101-2113-40fd-95e3-f925a305668a",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/Mindfulness%2FThumbnails%2Fmindful_3.PNG?alt=media&token=840ff67f-95ce-4e9f-9560-6a4248383425",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/Mindfulness%2FThumbnails%2Fmindful_4.PNG?alt=media&token=88c54a75-c39a-4151-a478-1c0ac4a61371",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/Mindfulness%2FThumbnails%2Fmindful_5.PNG?alt=media&token=943362fd-195f-4066-a907-45eb8100fa71"
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
