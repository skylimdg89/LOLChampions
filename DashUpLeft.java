package edu.mnstate.mg0483fp.lollogin;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import java.io.FileInputStream;


public class DashUpLeft extends Fragment {
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_up_left, container, false);

        final Button collection_button = (Button)view.findViewById(R.id.collection_button);
        collection_button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        buttonClicked(view);
                    }
                }
        );

        final Button champinfo_button = (Button)view.findViewById(R.id.champinfo_button);
        champinfo_button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        infobuttonClicked(view);
                    }
                }
        );

        return view;
    }

    public void buttonClicked(View view){
        Intent intent = new Intent(getActivity(), CollectionActivity.class);
        startActivity(intent);
    }

    public void infobuttonClicked(View view){
        Intent intent = new Intent(getActivity(), ChampionActivity.class);
        startActivity(intent);
    }



}
