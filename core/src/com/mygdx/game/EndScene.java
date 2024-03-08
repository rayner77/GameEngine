package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndScene extends Scenes{
	
	    
	    private Texture restartButton;
	    private String score;
	    private BitmapFont bitmapFontName;
	    private Texture background;
	    private Texture gameover;
	    
	    
	    //Constructor
	    public EndScene(SceneManager sm, String score, BitmapFont bitmapFontName){
	    	super(sm);
	    	bitmapFontName = new BitmapFont();
	        restartButton = new Texture("restart.png");
	        background = new Texture("bg.png");
	        gameover = new Texture("gameover.png");
	        this.score = score;
	        this.bitmapFontName = bitmapFontName;
	        
	    }

		@Override
		public void update(float dt) {
			// TODO Auto-generated method stub
			handleInput();
			
		}


		@Override
		public void render(SpriteBatch sb) {
			// TODO Auto-generated method stub
			//Render
	        sb.begin();
	        sb.draw(background, 0, 0, 480, 800);
	        sb.draw(gameover, 190, 500);    
	        // Draw the play button centered on the screen
	        float rstBtnX = (480 - restartButton.getWidth()) / 2f;
	        float rstBtnY = (800 - restartButton.getHeight()) / 2f;
	        sb.draw(restartButton, rstBtnX, rstBtnY);
	        bitmapFontName.setColor(0.0f, 0.0f, 0.0f, 1.0f);
            bitmapFontName.draw(sb, "Total "+ score, 25, 700);
	        sb.end();
			
		}

		@Override
		public void handleInput() {
			if (Gdx.input.justTouched()) {
			float x = Gdx.input.getX();
            float y = Gdx.graphics.getHeight() - Gdx.input.getY(); // Adjust the y-coordinate to LibGDX's coordinate system

            // Calculate the positions of the buttons
            float rstBtnX = (480 - restartButton.getWidth()) / 2f;
            float rstBtnY = (800 - restartButton.getHeight()) / 2f;
            
            // Transition to the game scene if the play button is pressed
            if (x >= rstBtnX && x <= rstBtnX + restartButton.getWidth() &&
                     y >= rstBtnY && y <= rstBtnY + restartButton.getHeight()) {
                sm.set(new StartScene(sm));
                dispose();
            }
            
            
		}
			
		}
		
		 @Override
		 public void dispose(){
		    //Dispose
		        
		 }
}


