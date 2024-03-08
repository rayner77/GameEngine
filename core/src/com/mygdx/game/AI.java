package com.mygdx.game;

import java.util.Random;

public class AI {
    private Entity entity;
    private int screenWidth, screenHeight;
    private Random random;

    public AI(Entity entity, int screenWidth, int screenHeight) {
        this.entity = entity;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.random = new Random();
    }

    void updateFalling(float deltaTime) {
        float newY = entity.getyPosition() - (300 * deltaTime); // Adjust the falling speed as needed

        if (newY <= 0) { // If the enemy reaches or goes below the ground level
            newY = screenHeight + random.nextInt(screenHeight); // Move it to a random position above the screen
            entity.setxPosition(random.nextInt(screenWidth - entity.getTexture().getWidth())); // Randomize x position
        }

        entity.setyPosition(newY);
    }


 // Define a direction variable
    boolean movingRight = true;
    void updateMoving(float deltaTime) {
        // Update x position based on direction
        if (movingRight) {
            entity.setxPosition(entity.getxPosition() + (100 * deltaTime)); // Adjust the horizontal speed as needed
        } else {
            entity.setxPosition(entity.getxPosition() - (100 * deltaTime)); // Adjust the horizontal speed as needed
        }

        // Reverse direction if the entity reaches the edge of the screen
        if (entity.getxPosition() <= 0 || entity.getxPosition() >= screenWidth - entity.getTexture().getWidth()) {
            movingRight = !movingRight;
        }

        // Ensure the entity stays within the bounds of the screen horizontally
        if (entity.getxPosition() < 0) {
            entity.setxPosition(0);
        } else if (entity.getxPosition() > screenWidth - entity.getTexture().getWidth()) {
            entity.setxPosition(screenWidth - entity.getTexture().getWidth());
        }
        // Set the vertical position to center of the screen
        int centerY = (screenHeight - entity.getTexture().getHeight()) / 2;
        entity.setyPosition(centerY);
    }

	public void moveAIControlled() {
		// TODO Auto-generated method stub
		
	}



}
