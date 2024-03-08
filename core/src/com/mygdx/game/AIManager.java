package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class AIManager {
    private List<AI> aiList;
    private Entity entity;

    public AIManager(Entity entity) {
    	 aiList = new ArrayList<>();
    	 this.entity = entity; 
    }

    public void addAI(AI ai) {
        aiList.add(ai);
    }

    public void moveEntities() {
       entity.checkAiControl();
        for (AI ai : aiList) {
            ai.moveAIControlled();
        }
        
    }
}

