package edu.mnstate.mg0483fp.lollogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class LeftFragment extends Fragment {

    VideoView loginView;
    int stopPosition;
    private SharedPreferences savedValues;
    private MediaController mMediaController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        loginView = (VideoView)view.findViewById(R.id.loginView);

        String path = "android.resource://edu.mnstate.mg0483fp.lollogin/" + R.raw.login;

        Uri uri = Uri.parse(path);

        loginView.setVideoURI(uri);

        //infinite loop of videoview
        loginView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        loginView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent){
                if(loginView.isPlaying()){
                    loginView.pause();
                    stopPosition = loginView.getCurrentPosition();
                    return false;
                }
                else{
                    loginView.start();
                    loginView.seekTo(stopPosition);
                    return false;
                }
            }
        });

        /*
        loginView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer)
            {
                //here
                loginView.seekTo(1);
            }
        });
        //here
        if (stopPosition != 1)
        {
            loginView.seekTo(stopPosition);
            loginView.start();
        }
        else
        {
            //here
            loginView.seekTo(1);
        }
        */

        loginView.start();

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if(loginView!=null) {
            stopPosition = loginView.getCurrentPosition();
            loginView.pause();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if(loginView!=null) {
            loginView.start();
            loginView.seekTo(stopPosition);
        }
    }


}
