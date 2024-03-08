package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SceneManager sm;
	private SpriteBatch sb;
	
	@Override
	public void create() {
		sb = new SpriteBatch();
		sm = new SceneManager();
		sm.push(new StartScene (sm));
		
		// initialize the sound manager to play music on loop
		SoundManager soundManager = SoundManager.getInstance();
	    soundManager.startMusic(true);
	}
	
	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		sm.update(Gdx.graphics.getDeltaTime());
		sm.render(sb);
	}
	
	@Override
	public void dispose() {
		sb.dispose();
		SoundManager.getInstance().dispose();
		
	}
}
