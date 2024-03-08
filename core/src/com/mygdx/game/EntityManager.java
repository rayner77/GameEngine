package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class EntityManager {
	private static EntityManager instance;
    private Vector2 pos;
    private Player player;
    private Prop tube;
    private Enemy enemybird;
    private Score score;
    private List<Entity> entityList = new ArrayList<Entity>();


    public EntityManager(Score score) {
        this.score = score;
        //this.aiManager = aiManager;

        player = new Player(1, 0, 0, "bird.png", "Player 1");
        tube = new Prop(2, 200, 0, "droplet.png", pos);
        enemybird = new Enemy(3, 300, 790, "enemy.png");

        for (int i = 0; i < 5; i++) {
            Reward reward = new Reward(4 + i, 200 + (i * 10), 200 + (i * 100), "star.png", score);
            addAIEntity(reward);
        }

        addAIEntity(player);
        addAIEntity(tube);
        addAIEntity(enemybird);
    }

	
    public void drawEntitiesWithBounds(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        for (Entity entity : entityList) {
            entity.draw(batch);
            // Draw bounds using ShapeRenderer
            Rectangle bounds = entity.getBounds();
            shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
    }
	
	
    public void drawEntities(SpriteBatch batch) {
        for (Entity entity : entityList) {
            entity.draw(batch);
        }
    }

    public void updateEntities() {
        for (Entity entity : entityList) {
            CollisionManager.handleCollisions(entityList);
            entity.update();
            //entity.checkAiControl(); // Call checkAiControl to determine movement type
        }
    }

    public static EntityManager getInstance(Score score) {
        if (instance == null) {
            instance = new EntityManager(score);
        }
        return instance;
    }
	
	public void moveEntities() {
		 
	        for (Entity entity : entityList) {
	        	entity.checkAiControl();
	            if (entity instanceof Enemy) {
	                ((Enemy) entity).moveAIControlled();
	            }
	        }
	    }

	 public void addAIEntity(Entity entity) {
		    entityList.add(entity);
		}

    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public Player getPlayer() {
        return player;
    }
	
}
