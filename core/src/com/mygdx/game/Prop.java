package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Prop extends Entity {
	private Vector2 pos;
	
	//constructor
	public Prop(int id, float x, float y, String imagePath, Vector2 pos) {
		super(id, x, y,imagePath,false);
		this.pos = pos;
	}
	
	//getters and setters
	public Vector2 getpos() {
		return pos;
	}
	
	void setpos (Vector2 pos) {
		this.pos = pos;
	}
	
	@Override
	public Rectangle getBounds() {
		return bounds;
	}
	
    @Override
    public void onCollision(Entity other) {
        if (other instanceof Player) {
        	System.out.println("Collision detected with: " + other.getClass().getSimpleName());
        	//score = getscore() + 1;
        	//GameManager.handleScoreIncrement(score);
        }
    }
    /*	@Override
	public void moveAIControlled() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUserControlled() {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void moveAIControlled() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUserControlled() {
		// TODO Auto-generated method stub
		
	}


	        
}
