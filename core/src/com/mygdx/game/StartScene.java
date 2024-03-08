package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartScene extends Scenes {
    private Texture background;
    private Texture playBtn;
    private Texture muteBtn;
    private Texture unmuteBtn;
    private boolean isMusicPlaying;
    
    private Texture currentButton;

    public StartScene(SceneManager sm) {
        super(sm);
        loadTextures();
        
        isMusicPlaying = true;
        updateButtonTexture();
    }
    
    private void loadTextures() {
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
        muteBtn = new Texture("muteBtn.png");
        unmuteBtn = new Texture("unmuteBtn.png");
    }
    
    private void updateButtonTexture() {
        currentButton = isMusicPlaying ? muteBtn : unmuteBtn;
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            float x = Gdx.input.getX();
            float y = Gdx.graphics.getHeight() - Gdx.input.getY(); // Adjust the y-coordinate to LibGDX's coordinate system

            // Calculate the positions of the buttons
            float playBtnX = (480 - playBtn.getWidth()) / 2f;
            float playBtnY = (800 - playBtn.getHeight()) / 2f;
            
            float buttonX = (480 - currentButton.getWidth()) / 2f;
            float spacing = 20f; 
            float buttonY = playBtnY - playBtn.getHeight() - spacing; 

            // Toggle music on or off
            if (x >= buttonX && x <= buttonX + currentButton.getWidth() &&
                y >= buttonY && y <= buttonY + currentButton.getHeight()) {
                isMusicPlaying = !isMusicPlaying;
                updateButtonTexture(); // Update the button texture to reflect the new state
                if (isMusicPlaying) {
                    SoundManager.getInstance().playMusic();
                } else {
                    SoundManager.getInstance().pauseMusic();
                }
            }
            // Transition to the game scene if the play button is pressed
            else if (x >= playBtnX && x <= playBtnX + playBtn.getWidth() &&
                     y >= playBtnY && y <= playBtnY + playBtn.getHeight()) {
                sm.set(new GameScene(sm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, 480, 800);
        
        // Draw the play button centered on the screen
        float playBtnX = (480 - playBtn.getWidth()) / 2f;
        float playBtnY = (800 - playBtn.getHeight()) / 2f;
        sb.draw(playBtn, playBtnX, playBtnY);

        // Calculate and draw the position of the current button (mute/unmute)
        float spacing = 20f; // for spacing
        float buttonX = (480 - currentButton.getWidth()) / 2f;
        float buttonY = playBtnY - playBtn.getHeight() - spacing;
        sb.draw(currentButton, buttonX, buttonY);
        
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        muteBtn.dispose();
        unmuteBtn.dispose();
    }
}