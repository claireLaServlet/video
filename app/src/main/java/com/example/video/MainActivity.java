package com.example.video;

import android.net.Uri;
import android.support.v4.widget.ListViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    VideoView video;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video = (VideoView)findViewById(R.id.videoView);

        //Controleur lecteur   video
        MediaController mc = new MediaController(this);
        mc.setAnchorView(video);
        video.setMediaController(mc);
        Uri chemin = Uri.parse("/mnt/sdcard/DCIM/Camera/VID_20190415_141647.mp4");
        video.setVideoURI(chemin);
        video.start();
        afficherListe();

    }

    private void afficherListe(){
        File dir = new File("/mnt/sdcard/Movies/Messenger");
        final String items[]=dir.list();
        list = (ListView)findViewById(R.id.lisTView);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = list.getItemAtPosition(position);

            }
        });
    }


}
