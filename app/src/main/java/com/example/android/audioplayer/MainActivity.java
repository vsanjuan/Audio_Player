package com.example.android.audioplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private float currVolume = 100;
    private float maxVolume = 100;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.anagha);



        final Button play = (Button) findViewById(R.id.play_audio);
        final Button pause = (Button) findViewById(R.id.pause_audio);
        final Button inc_volume = (Button) findViewById(R.id.inc_volume);
        final Button dec_volume = (Button) findViewById(R.id.dec_volume);

        play.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                mediaPlayer.start();
                Toast.makeText(getApplicationContext(),"Hola",Toast.LENGTH_SHORT).show();

            }

        });

        pause.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                mediaPlayer.pause();

            }

        });


        inc_volume.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                currVolume = currVolume + 10;
                float log1 = (float) (Math.log(maxVolume - currVolume) / Math.log(maxVolume));

                mediaPlayer.setVolume(1 - log1, 1 - log1);

            }

        });

        dec_volume.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                currVolume = currVolume - 10;
                float log1 = (float) (Math.log(maxVolume - currVolume) / Math.log(maxVolume));


                mediaPlayer.setVolume(1 - log1, 1 - log1);


            }

        });

        mediaPlayer.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer m) {

                Toast.makeText(getApplicationContext(),"Hola",Toast.LENGTH_SHORT).show();
                mediaPlayer.release();
        }

        });



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.audioplayer/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.audioplayer/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

