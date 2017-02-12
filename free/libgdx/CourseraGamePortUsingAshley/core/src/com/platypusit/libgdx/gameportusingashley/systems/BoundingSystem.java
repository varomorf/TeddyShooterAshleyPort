package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.audio.Sound;
import com.platypusit.libgdx.gameportusingashley.ComponentMappers;
import com.platypusit.libgdx.gameportusingashley.components.BoundedComponent;
import com.platypusit.libgdx.gameportusingashley.components.BoundsBounceableComponent;
import com.platypusit.libgdx.gameportusingashley.components.DrawableComponent;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;

/**
 * <p>System for bounding the position of entities to limits.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class BoundingSystem extends IteratingSystem {

    private static final Family family = Family.all(PositionComponent.class, BoundedComponent.class).get();

    public BoundingSystem() {
        super(family);
    }

    public BoundingSystem(int priority) {
        super(family, priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = ComponentMappers.position.get(entity);
        DrawableComponent drawable = ComponentMappers.drawable.get(entity);
        BoundedComponent bounds = ComponentMappers.bounds.get(entity);

        int halfWidth = drawable.texture.getWidth() / 2;
        int halfHeight = drawable.texture.getHeight() / 2;

        // clamp y position
        position.x = Math.max(bounds.leftBound + halfWidth, position.x);
        position.x = Math.min(bounds.rightBound - halfWidth, position.x);

        // clamp y position
        position.y = Math.max(bounds.bottomBound + halfHeight, position.y);
        position.y = Math.min(bounds.topBound - halfHeight, position.y);
    }

}
