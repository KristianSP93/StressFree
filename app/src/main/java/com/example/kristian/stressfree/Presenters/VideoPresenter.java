package com.example.kristian.stressfree.Presenters;

import com.example.kristian.stressfree.Views.VideoActivity;

public class VideoPresenter {

    private VideoPresenter.Context view;
    private String[] natureList, natureThumbnail, animalList, animalThumbnail;

    public VideoPresenter(VideoActivity view){
        this.view = view;

        natureList = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FVideos%2FForest_video.mov?alt=media&token=8d031179-0d13-469c-a9b3-0f48d9e0d15c",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FVideos%2FWaterfall_video.mp4?alt=media&token=f86b77b0-ccbb-4ad2-9375-321fd4d7abca"
        };

        natureThumbnail = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FThumbnails%2FForest_thumbnail.PNG?alt=media&token=c4eb9f4f-8e69-49e2-b64b-21b78f37dfb9",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoNature%2FThumbnails%2FWaterfall_thumbnail.PNG?alt=media&token=78921c5e-3871-4d16-a4fd-bacb92e3ae83"
        };

        animalList = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoAnimal%2FVideos%2FMonkey_video.mp4?alt=media&token=c494af0f-86d5-4f58-b454-37c16e754f7a",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoAnimal%2FVideos%2FJellyfish_video.mp4?alt=media&token=62ce0965-7d38-4ccd-806a-f40807d6d66b",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoAnimal%2FVideos%2FCampfire.mp4?alt=media&token=dc5cc388-aaf3-4b1c-9115-8e9a1614fe37"
        };

        animalThumbnail = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoAnimal%2FThumbnails%2FMonkey_thumbnail.PNG?alt=media&token=5e981121-f616-409d-b8fe-c76676910c17",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoAnimal%2FThumbnails%2FJellyfish_thumbnail.PNG?alt=media&token=11fc6b79-fefa-48fe-be64-18761d041ffa",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/VideoAnimal%2FThumbnails%2FJellyfish_thumbnail.PNG?alt=media&token=11fc6b79-fefa-48fe-be64-18761d041ffa"
        };
    }


    public String[] getNatureList() {
        return natureList;
    }

    public String[] getNatureThumbnail() {
        return natureThumbnail;
    }

    public String[] getAnimalList() {
        return animalList;
    }

    public String[] getAnimalThumbnail() {
        return animalThumbnail;
    }

    // Interface to the methods in MyStressFree
    public interface Context {

    }
}
