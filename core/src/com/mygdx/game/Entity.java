package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entity implements iMovable {
	protected int id;
	protected float xPosition, yPosition;
	protected Texture tex;
	protected SpriteBatch batch;
	protected Rectangle bounds;
	protected boolean isAiControl;


	
	//constructor
	public Entity(int id, float x, float y, String imagePath, boolean isAiControl) {
		    this.id = id;
	        this.xPosition = x;
	        this.yPosition = y;
	        this.tex = new Texture(Gdx.files.internal(imagePath));
	        this.isAiControl = isAiControl;


		
		float width = tex.getWidth();
		float height = tex.getHeight();
		
		this.bounds = new Rectangle(x, y, width, height);
	}

	//getters and setters
	public int getid() {
		return id;
	}
	
	void setid(int id) {
		this.id = id;
	}
	
	public float getxPosition() {
		return xPosition;
	}
	
	void setxPosition(float x) {
		this.xPosition = x;
	}
	
	public float getyPosition() {
		return yPosition;
	}
	
	void setyPosition(float y) {
		this.yPosition = y;
	}
	
	public Texture getTexture() {
		return tex;
	}
	
	void setTexture(Texture t) {
		this.tex = t;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	//methods
	public void draw(SpriteBatch batch) {
		batch.draw(getTexture(), getxPosition(),getyPosition(),getTexture().getWidth(), getTexture().getHeight());
	}
	
	public abstract void onCollision(Entity other);
	
	public void update() {
		bounds.setPosition(getxPosition(), getyPosition());
	}
	
	//common method dispose
	public void dispose() {
	}


    public void checkAiControl() { /* ------------------ */
        if (isAiControl) {
            moveAIControlled();
        } else {
            moveUserControlled();
        }
    }
}


