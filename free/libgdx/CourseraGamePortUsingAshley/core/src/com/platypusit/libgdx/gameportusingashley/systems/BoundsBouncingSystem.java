package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.audio.Sound;
import com.platypusit.libgdx.gameportusingashley.ComponentMappers;
import com.platypusit.libgdx.gameportusingashley.components.*;

/**
 * <p>System for bouncing off bounds.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class BoundsBouncingSystem extends IteratingSystem {

    private static final Family family = Family.all(PositionComponent.class, BoundedComponent.class, BoundsBounceableComponent.class).get();

    private Sound bouncingSound;

    public BoundsBouncingSystem(Sound bouncingSound) {
        super(family);
        this.bouncingSound = bouncingSound;
    }

    public BoundsBouncingSystem(Sound bouncingSound, int priority) {
        super(family, priority);
        this.bouncingSound = bouncingSound;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        boolean hasBounced = false;
        PositionComponent position = ComponentMappers.position.get(entity);
        VelocityComponent velocity = ComponentMappers.velocity.get(entity);
        DrawableComponent drawable = ComponentMappers.drawable.get(entity);
        BoundedComponent bounds = ComponentMappers.bounds.get(entity);

        int halfWidth = drawable.texture.getWidth() / 2;
        float left = position.x - halfWidth;
        float right = position.x + halfWidth;
        int halfHeight = drawable.texture.getHeight() / 2;
        float bottom = position.y - halfHeight;
        float top = position.y + halfHeight;

        // check horizontal bouncing
        if (left <= bounds.leftBound || right >= bounds.rightBound) {
            // bounce off horizontally
            velocity.x *= -1;

            hasBounced = true;
        }

        // check vertical bouncing
        if (bottom <= bounds.bottomBound || top >= bounds.topBound) {
            // bounce off vertically
            velocity.y *= -1;

            hasBounced = true;
        }

        // play bouncing sound if necessary
        if (hasBounced) {
            bouncingSound.play(1);
        }
    }

}
