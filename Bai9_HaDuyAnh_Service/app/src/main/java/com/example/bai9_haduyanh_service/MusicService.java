package com.example.bai9_haduyanh_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    MediaPlayer mymusic;
    //giao tiếp với các thành phần ứng dụng khác trong quá trình
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //Gọi hàm onCreate để khởi tạo đối tượng mà Service quản lí
    @Override
    public void onCreate() {
        super.onCreate();
        mymusic = MediaPlayer.create(this, R.raw.duanhauditron);
        mymusic.setLooping(true);
    }
    //gọi hàm onStart để khởi chạy đối tượng Service quản lí
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mymusic.isPlaying())
            mymusic.pause();
        else
            mymusic.start();
    }
    //gọi hàm onDestroy để dừng đối tượng Service quản lí
    @Override
    public void onDestroy() {
        super.onDestroy();
        mymusic.stop();
    }

}