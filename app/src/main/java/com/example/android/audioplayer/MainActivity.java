package com.example.android.audioplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private float currVolume = 100;
    private float maxVolume = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.anagha );

        final Button play = (Button) findViewById(R.id.play_audio);
        final Button pause = (Button) findViewById(R.id.pause_audio);
        final Button inc_volume = (Button) findViewById(R.id.inc_volume);
        final Button dec_volume = (Button) findViewById(R.id.dec_volume);

        play.setOnClickListener( new View.OnClickListener() {

            public void onClick(View view) {

                mediaPlayer.start();

            }

        });

        pause.setOnClickListener( new View.OnClickListener() {

            public void onClick(View view) {

                mediaPlayer.pause();

            }

        });






        inc_volume.setOnClickListener( new View.OnClickListener() {

            public void onClick(View view) {

                currVolume = currVolume + 10;

                AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
                float  volume_level = am.getStreamVolume(AudioManager.STREAM_MUSIC);
                float log1=(float)(Math.log(maxVolume-currVolume )/Math.log(maxVolume));


                Log.v("Initial volume", "Volume starts: " + Float.toString(volume_level));

                mediaPlayer.setVolume(1-log1,1-log1);

            }

        });

        dec_volume.setOnClickListener( new View.OnClickListener() {

            public void onClick(View view) {

                currVolume = currVolume - 10;

                AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
                float  volume_level = am.getStreamVolume(AudioManager.STREAM_MUSIC);
                float log1=(float)(Math.log(maxVolume-currVolume )/Math.log(maxVolume));


                Log.v("Initial volume", "Volume starts: " + Float.toString(volume_level));

                mediaPlayer.setVolume(1-log1,1-log1);



            }

        });

    }
}

