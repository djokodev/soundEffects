package com.djokodev.soundeffect;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.my_sound1);
        this.mSeekBar = (SeekBar) findViewById(R.id.sound_bar);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mSeekBar.setProgress(mMediaPlayer.getCurrentPosition() / 100);
            }
        }, 100, 100);

    }

    public void playSound(View view)
    {
        Button button = (Button) view;

        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            button.setText(getString(R.string.play1));
        }

        else {
            mMediaPlayer.start();
            button.setText(getString(R.string.pause));
        }
    }
}