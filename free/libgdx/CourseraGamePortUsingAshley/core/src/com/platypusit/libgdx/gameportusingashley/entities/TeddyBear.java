package com.platypusit.libgdx.gameportusingashley.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.platypusit.libgdx.gameportusingashley.components.*;
import com.platypusit.libgdx.gameportusingashley.constant.GameConstants;

import static com.platypusit.libgdx.gameportusingashley.components.factory.BoundsBounceableComponentFactory.worldBounceableComponent;
import static com.platypusit.libgdx.gameportusingashley.constant.GameConstants.TEDDY_BEAR_PROJECTILE_OFFSET;
import static com.platypusit.libgdx.gameportusingashley.constant.ProjectileType.TEDDY_BEAR;

/**
 * Entity for Teddy Bears.
 * Created by alfergon on 30/01/17.
 */
public class TeddyBear extends Entity {

    public TeddyBear(Texture texture, float x, float y, Vector2 velocity, Sound teddyBounce, Sound teddyShot) {
        add(new PositionComponent(x, y));
        add(new VelocityComponent(velocity.x, velocity.y));
        add(new DrawableComponent(texture));
        add(worldBounceableComponent);
        add(new ShootingComponent(TEDDY_BEAR, -TEDDY_BEAR_PROJECTILE_OFFSET, teddyShot));
        add(new TimedShootingComponent(GameConstants.BEAR_FIRING_RATE_RANGE));
    }
}
