package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter {
	   private Player player;
	   private int keyLeft;
	   private int keyRight;
	   private int keyUp;
	   private int keyDown;
	   
	   
	   public InputManager(Player player, int keyUp, int keyDown, int keyLeft, int keyRight)  {
	       this.player = player;
	       this.keyLeft = keyLeft;
	       this.keyRight = keyRight;
	       this.keyUp = keyUp;
	       this.keyDown = keyDown;

	   }
	   public int getKeyLeft() {
	       return keyLeft;
	   }
	   public void setKeyLeft(int keyLeft) {
	       this.keyLeft = keyLeft;
	   }
	   public int getKeyRight() {
	       return keyRight;
	   }
	   public void setKeyRight(int keyRight) {
	       this.keyRight = keyRight;
	   }
	   public int getKeyUp() {
	       return keyUp;
	   }
	   public void setKeyUp(int keyUp) {
	       this.keyUp = keyUp;
	   }
	   public int getKeyDown() {
	       return keyDown;
	   }
	   public void setKeyDown(int keyDown) {
	       this.keyDown = keyDown;
	   }
	   
	   
	   
	   public void update() {
	       if (Gdx.input.isKeyPressed(keyLeft)) {
	           player.moveLeft();
	       }
	       if (Gdx.input.isKeyPressed(keyRight)) {
	           player.moveRight();        
	       }
	       if (Gdx.input.isKeyPressed(keyUp)) {
	            player.moveUp();
	       }
	       if (Gdx.input.isKeyPressed(keyDown)) {
	            player.moveDown();
	       }
	   }
	}