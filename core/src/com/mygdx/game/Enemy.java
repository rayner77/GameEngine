package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Enemy extends Entity {
    private AI ai;


    // Constructor
    public Enemy(int id, float x, float y, String imagePath) {
        super(id, x, y, imagePath, true);
        ai = new AI(this, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // Instantiate AI object
    }

    @Override
    public void onCollision(Entity other) {
        if (other instanceof Player) {
            System.out.println("Collision detected with: " + other.getClass().getSimpleName());
            // Collision with Enemy, handle Game Over logic
            // GameManager.handleGameOver();
        }
    }

    @Override
    public void moveAIControlled() {
        ai.updateMoving(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void moveUserControlled() {
        // TODO: Implement user-controlled movement logic if needed
    }

}
