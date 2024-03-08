package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class SoundManager {

    private static SoundManager instance;
    private Music bgmusic; 

    private SoundManager() {
        // Load the music track
        bgmusic = Gdx.audio.newMusic(Gdx.files.internal("soundtrack.mp3")); 
    }

    public void playMusic() {
        if (!bgmusic.isPlaying()) {
            bgmusic.play();
        }
    }

    public void pauseMusic() {
        if (bgmusic.isPlaying()) {
            bgmusic.pause();
        }
    }

    public void setVolume(float value) {
        bgmusic.setVolume(value);
    }

    public float getVolume() {
        return bgmusic.getVolume();
    }

    public boolean isPlaying() {
        return bgmusic.isPlaying();
    }

    public void setLooping(boolean loop) {
        bgmusic.setLooping(loop);
    }
    
    public void startMusic(boolean shouldPlay) {
        if (shouldPlay) {
            playMusic();
            setLooping(true);
        } else {
            pauseMusic();
        }
    }

    public static SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    
    public void dispose() {
        if (bgmusic != null) {
            bgmusic.dispose();
        }
    }
}