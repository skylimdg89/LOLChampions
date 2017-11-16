package edu.mnstate.mg0483fp.lollogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import static android.content.Context.MODE_PRIVATE;


public class DashMiddle extends Fragment {
    VideoView middleView;
    int stopPosition;
    private SharedPreferences savedValues;
    boolean videoFlag=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dash_middle, container, false);
        middleView = (VideoView)view.findViewById(R.id.videoView);
        savedValues = getActivity().getSharedPreferences("SavedValues", MODE_PRIVATE);

        String path = "android.resource://edu.mnstate.mg0483fp.lollogin/" + R.raw.zoe;
        MediaController mediaController = new MediaController(getActivity());
        Uri uri = Uri.parse(path);

        middleView.setVideoURI(uri);

        //infinite loop of videoview
        middleView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        middleView.setMediaController(mediaController);
        middleView.start();


        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if(middleView!=null) {
            stopPosition = middleView.getCurrentPosition();
            middleView.pause();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if(middleView!=null) {
            middleView.start();
            middleView.seekTo(stopPosition);
        }
    }
}
