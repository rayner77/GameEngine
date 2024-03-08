package com.mygdx.game;
import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class SceneManager {

   private Stack<Scenes> scenes;
	
	public SceneManager() {
		scenes = new Stack<Scenes>(); //new object scene
	}
	
	public void push(Scenes scene) {
		scenes.push(scene);
	}
	
	public void pop() {
		scenes.pop().dispose(); //remove scene since no longer needed
	}
	
	public void set(Scenes scene) {
		scenes.pop();
		scenes.push(scene);
	}
	
	public void update(float dt)
	{
		scenes.peek().update(dt);
	}
		
	
	public void render(SpriteBatch sb) {
		scenes.peek().render(sb);
	}
}