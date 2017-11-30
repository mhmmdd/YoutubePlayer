package com.example.tshb.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 * Created by tshb on 26.11.2017.
 */

public class StandaloneActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button buttonPlayVideo = (Button) findViewById(R.id.buttonPlayVideo);
        Button buttonPlayList = (Button) findViewById(R.id.buttonPlayList);

        buttonPlayVideo.setOnClickListener(this);

//        View.OnClickListener ourListener = new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//            }
//        };
//
//        buttonPlayVideo.setOnClickListener(ourListener);
//        buttonPlayList.setOnClickListener(ourListener);
//
//        buttonPlayVideo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch(view.getId()) {
            case R.id.buttonPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST);
                break;
            case R.id.buttonPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST);
                break;
            default:
        }

        if(intent != null) {
            startActivity(intent);
        }
    }
}
