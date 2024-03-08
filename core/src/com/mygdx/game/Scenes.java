package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class Scenes {
	
	protected OrthographicCamera cam;
	  protected Vector3 mouse;
      protected SceneManager sm;

      protected Scenes(SceneManager sm) {
		this.sm = sm;
		cam = new OrthographicCamera();
		mouse = new Vector3();
	  }

      public abstract void update(float dt);
      public abstract void render(SpriteBatch sb);
      public abstract void handleInput();
      public abstract void dispose();

}
