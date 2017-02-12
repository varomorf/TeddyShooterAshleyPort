package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.platypusit.libgdx.gameportusingashley.ComponentMappers;
import com.platypusit.libgdx.gameportusingashley.components.BoundsBounceableComponent;
import com.platypusit.libgdx.gameportusingashley.components.DrawableComponent;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;
import com.platypusit.libgdx.gameportusingashley.components.VelocityComponent;

/**
 * <p>System for bounds bouncing.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class BoundsBouncingSystem extends IteratingSystem {

    private static final Family family = Family.all(PositionComponent.class, BoundsBounceableComponent.class).get();

    public BoundsBouncingSystem() {
        super(family);
    }

    public BoundsBouncingSystem(int priority) {
        super(family, priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = ComponentMappers.position.get(entity);
        VelocityComponent velocity = ComponentMappers.velocity.get(entity);
        DrawableComponent drawable = ComponentMappers.drawable.get(entity);
        BoundsBounceableComponent boundsBouncing = ComponentMappers.boundsBounceable.get(entity);

        float left = position.x - (drawable.texture.getWidth() / 2);
        float right = position.x + (drawable.texture.getWidth() / 2);
        float bottom = position.y - (drawable.texture.getHeight() / 2);
        float top = position.y + (drawable.texture.getHeight() / 2);

        // check horizontal bouncing
        if (left <= boundsBouncing.leftBound || right >= boundsBouncing.rightBound) {
            // bounce off horizontally
            velocity.x *= -1;
            // clamp y position
            position.x = Math.max(boundsBouncing.leftBound, position.x);
            position.x = Math.min(boundsBouncing.rightBound, position.x);
        }

        // check vertical bouncing
        if (bottom <= boundsBouncing.bottomBound || top >= boundsBouncing.topBound) {
            // bounce off vertically
            velocity.y *= -1;
            // clamp y position
            position.y = Math.max(boundsBouncing.bottomBound, position.y);
            position.y = Math.min(boundsBouncing.topBound, position.y);
        }


    }

}
