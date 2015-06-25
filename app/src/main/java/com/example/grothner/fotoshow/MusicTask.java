package com.example.grothner.fotoshow;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by rgruber on 25.06.2015.
 */
public class MusicTask extends AsyncTask<String, Void, Boolean> {
    private Activity activity;

    public MusicTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        String url = strings[0]; // your URL here ""
        Log.d(this.getClass().getSimpleName(), "loading media");
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.start();

            Log.d(this.getClass().getSimpleName(), "starting media player");
            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if(!success) {
            Toast.makeText(activity, activity.getString(R.string.music_error), Toast.LENGTH_LONG).show();
        }
    }
}
