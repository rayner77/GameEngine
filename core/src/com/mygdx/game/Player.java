package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;


public class Player extends Entity {
	private String name;
	public Score score;
	private boolean scoreHandle;
	
	//constructor
	public Player(int id, float x, float y, String imagePath, String name) {
		super(id, x, y,imagePath,false);
		this.name = name;
		score = new Score();
	}
	
	//getters and setters
	public String getname() {
		return name;
	}
	
	void setname(String name) {
		this.name = name;		
	}
	
	@Override
	public Rectangle getBounds() {
		return bounds;
	}
	
	
	
	//methods
    public void moveLeft() {
        float newX = getxPosition() - Gdx.graphics.getDeltaTime() * 200;
        if (newX < 0) {
            newX = 0; // Prevent moving out of the left screen boundary
        }
        setxPosition(newX);
        updateBounds();
    }

    public void moveRight() {
        float newX = getxPosition() + Gdx.graphics.getDeltaTime() * 200;
        float maxWidth = Gdx.graphics.getWidth() - this.tex.getWidth();
        if (newX > maxWidth) {
            newX = maxWidth; // Prevent moving out of the right screen boundary
        }
        setxPosition(newX);
        updateBounds();
    }

    public void moveUp() {
        float newY = getyPosition() + Gdx.graphics.getDeltaTime() * 200;
        float maxHeight = Gdx.graphics.getHeight() - this.tex.getHeight();
        if (newY > maxHeight) {
            newY = maxHeight; // Prevent moving out of the top screen boundary
        }
        setyPosition(newY);
        updateBounds();
    }

    public void moveDown() {
        float newY = getyPosition() - Gdx.graphics.getDeltaTime() * 200;
        if (newY < 0) {
            newY = 0; // Prevent moving out of the bottom screen boundary
        }
        setyPosition(newY);
        updateBounds();
    }
    
    private void updateBounds() {
        // Update the bounds to reflect the new position
        this.bounds.setPosition(getxPosition(), getyPosition());
    }
	
	
	 @Override
	    public void onCollision(Entity other) {
	        if (other instanceof Enemy) {
	        	System.out.println("Collision detected with: " + other.getClass().getSimpleName());
	            //GameManager.handleGameOver();
	        } 
	        
	        if (other instanceof Prop) {
	        	System.out.println("Collision detected with: " + other.getClass().getSimpleName());
	        }
	        
	        if (other instanceof Reward) {
	        	System.out.println("Collision detected with: " + other.getClass().getSimpleName());
	        	scoreHandle = true;
                score.decreaseScore(2); 
	        }
                else{
                	scoreHandle = false;
                }
	        }

	@Override
	public void moveAIControlled() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUserControlled() {
		// TODO Auto-generated method stub
		
	}

/*	@Override
	public void moveAIControlled() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUserControlled() {
		// TODO Auto-generated method stub
		
	}*/
	        
}

