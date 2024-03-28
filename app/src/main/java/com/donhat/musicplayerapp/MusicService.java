package com.donhat.musicplayerapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    private MediaPlayer _player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        _player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        _player.setLooping(true);
        _player.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        _player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
