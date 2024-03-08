package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import java.util.List;

public class CollisionManager {
    public static boolean checkCollision(Rectangle entity1, Rectangle entity2) {
        return entity1.overlaps(entity2);
    }

    public static void handleCollisions(List<Entity> entities) {
        int size = entities.size();
        for (int i = 0; i < size - 1; i++) {
            Entity entity1 = entities.get(i);
            Rectangle bounds1 = entity1.getBounds();

            for (int j = i + 1; j < size; j++) {
                Entity entity2 = entities.get(j);
                Rectangle bounds2 = entity2.getBounds();

                if (checkCollision(bounds1, bounds2)) {
                    // Only call onCollision when a collision is detected
                	//System.out.println("Collided!");
                	//System.out.println("Bounds1: " + bounds1);
                   // System.out.println("Bounds2: " + bounds2);
                    entity1.onCollision(entity2);
                    entity2.onCollision(entity1);
                }
            }
        }
    }
}
