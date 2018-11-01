package com.example.kristian.stressfree.Models;

public class Music {

    public Music(String songName, String singer, int song) {
        this.songName = songName;
        this.singer = singer;
        this.song = song;
    }

    private String songName;
    private String singer;
    private int song;



    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }




}
