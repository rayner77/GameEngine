

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameScene extends Scenes{
	public Score score;
    private Texture background;
    public BitmapFont bitmapFontName;
    private Texture playBtn;
    private Texture pauseBtn;
    private boolean paused;
    private boolean pauseKeyHandled; // Add a flag to track if the pause key has been handled
    private boolean scoreHandle;
	private EntityManager entityManager;
	private InputManager inputManager;
	private AIManager AIManager;
	//private ShapeRenderer shape;

    public GameScene(SceneManager sm) {
        super(sm);
        score = new Score();
        bitmapFontName = new BitmapFont();
        background = new Texture("bg.png");
        playBtn = new Texture("playBtn.png");
        pauseBtn = new Texture ("pause.png");
        paused = false;
        pauseKeyHandled = false; // Initialize the flag as false
        scoreHandle = false;
        entityManager = new EntityManager(score);
		inputManager = new InputManager(entityManager.getPlayer(), Keys.W, Keys.S, Keys.A, Keys.D);
		
		EntityManager.getInstance(score).setPlayer(entityManager.getPlayer());
		//shape = new ShapeRenderer();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Keys.P) && !pauseKeyHandled) {
            paused = !paused;
            pauseKeyHandled = true; // Set the flag to true to indicate the key press has been handled
        } else if (!Gdx.input.isKeyPressed(Keys.P)) {
            pauseKeyHandled = false; // Reset the flag when the key is released
        }
        
        // handle escape key to move back to StartScene
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            sm.set(new StartScene(sm));
            dispose();
            return; // to prevent future input handling
        }

        // only increment score with M key if the game is not paused
        if (!paused) { // to check if the game is paused
            if (Gdx.input.isKeyPressed(Keys.M) && !scoreHandle) {
                scoreHandle = true;
                score.addScore(2); 
            } else if (!Gdx.input.isKeyPressed(Keys.M)) {
                scoreHandle = false; 
            }
        }

        if (score.getScore() == 10) {
            sm.set(new EndScene(sm, score.displayScoreasStr(), bitmapFontName));
            dispose();
        }
    
    }

    @Override
    public void update(float dt) {
    	
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        if (!paused) {
        	
            // Render game elements only when not paused
        	//shape.begin(ShapeRenderer.ShapeType.Line);
            sb.begin();
            sb.draw(background, 0, 0, 480, 800);
            bitmapFontName.setColor(0.0f, 0.0f, 0.0f, 1.0f);
            bitmapFontName.draw(sb, score.displayScoreasStr(), 25, 100);    
    		entityManager.drawEntities(sb);
            //entityManager.drawEntitiesWithBounds(sb, shape);
    		entityManager.updateEntities();
    		entityManager.moveEntities();
    		inputManager.update();
            
            sb.end();
            //shape.end();
        } else {
            // Render play button and other paused elements
            sb.begin();
            sb.draw(background, 0, 0, 480, 800);
            sb.draw(pauseBtn,(480/2)-(pauseBtn.getWidth()/2),800/2);
            bitmapFontName.setColor(0.0f, 0.0f, 0.0f, 1.0f);
            bitmapFontName.draw(sb, score.displayScoreasStr(), 25, 100);
            sb.end();
            

        }
    }

    @Override
    public void dispose() {
        // Dispose of resources
        background.dispose();
        playBtn.dispose();
        bitmapFontName.dispose();
    }
}
/*
 * package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScene extends Scenes {
    public Score score;
    private Texture background;
    public BitmapFont bitmapFontName;
    private Texture pauseBtn;
    private boolean paused;
    private boolean pauseKeyHandled; // Add a flag to track if the pause key has been handled
    private boolean scoreHandle;
    private EntityManager entityManager;
    private InputManager inputManager;

    public GameScene(SceneManager sm) {
        super(sm);
        score = new Score();
        bitmapFontName = new BitmapFont();
        background = new Texture("bg.png");
        pauseBtn = new Texture("pause.png");
        paused = false;
        pauseKeyHandled = false; // Initialize the flag as false
        scoreHandle = false;
        entityManager = new EntityManager(score);
        inputManager = new InputManager(entityManager.getPlayer(), Keys.W, Keys.S, Keys.A, Keys.D);
    }
    @Override
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Keys.P) && !pauseKeyHandled) {
            paused = !paused;
            pauseKeyHandled = true; // Set the flag to true to indicate the key press has been handled
        } else if (!Gdx.input.isKeyPressed(Keys.P)) {
            pauseKeyHandled = false; // Reset the flag when the key is released
        }

        // handle escape key to move back to StartScene
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            sm.set(new StartScene(sm));
            dispose();
            return; // to prevent future input handling
        }

        // only increment score with M key if the game is not paused
        if (!paused) { // to check if the game is paused
            if (Gdx.input.isKeyPressed(Keys.M) && !scoreHandle) {
                scoreHandle = true;
                score.addScore(2);
            } else if (!Gdx.input.isKeyPressed(Keys.M)) {
                scoreHandle = false;
            }
        }

        if (score.getScore() == 10) {
            sm.set(new EndScene(sm, score.displayScoreasStr(), bitmapFontName));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        if (!paused) {
            // Render game elements only when not paused
            sb.begin();
            sb.draw(background, 0, 0, 480, 800);
            bitmapFontName.setColor(0.0f, 0.0f, 0.0f, 1.0f);
            bitmapFontName.draw(sb, score.displayScoreasStr(), 25, 100);
            entityManager.drawEntities(sb);
            entityManager.updateEntities();
            entityManager.moveEntities();
            inputManager.update();
            sb.end();
        } else {
            // Render pause button and other paused elements
            sb.begin();
            sb.draw(background, 0, 0, 480, 800);
            sb.draw(pauseBtn, (480 / 2) - (pauseBtn.getWidth() / 2), 800 / 2);
            bitmapFontName.setColor(0.0f, 0.0f, 0.0f, 1.0f);
            bitmapFontName.draw(sb, score.displayScoreasStr(), 25, 100);
            sb.end();
        }
    }

    @Override
    public void dispose() {
        // Dispose of resources
        background.dispose();
        pauseBtn.dispose();
        bitmapFontName.dispose();
    }
}
*/
