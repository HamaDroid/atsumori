package com.hmdroid.atsumori;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
private SoundPool mSoundPool;
private int[] mSoundID;
private  int[] mSoundResource={
        R.raw.nomal_atumori
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSoundPool = new SoundPool(mSoundResource.length, AudioManager.STREAM_MUSIC, 0);
        mSoundID = new int[mSoundResource.length];
        for (int i = 0; i < mSoundResource.length; i++) {
            mSoundID[i] = mSoundPool.load(getApplicationContext(), mSoundResource[i], 0);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        mSoundPool.release();
    }
public void atumori(View v){
    mSoundPool.play(mSoundID[0],1.0F,1.0F,0,0,.0F);
}

}