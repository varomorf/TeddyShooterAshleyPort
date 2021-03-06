package com.platypusit.libgdx.gameportusingashley.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.platypusit.libgdx.gameportusingashley.RandomNumberGenerator;
import com.platypusit.libgdx.gameportusingashley.components.*;
import com.platypusit.libgdx.gameportusingashley.constant.GameConstants;

import static com.platypusit.libgdx.gameportusingashley.components.SpawnableBearComponent.spawnableBearComponent;
import static com.platypusit.libgdx.gameportusingashley.components.factory.BoundedComponentFactory.worldBoundedComponent;
import static com.platypusit.libgdx.gameportusingashley.constant.GameConstants.BEAR_FIRING_RATE_RANGE;
import static com.platypusit.libgdx.gameportusingashley.constant.GameConstants.TEDDY_BEAR_PROJECTILE_OFFSET;
import static com.platypusit.libgdx.gameportusingashley.constant.ProjectileType.TEDDY_BEAR;

/**
 * Entity for Teddy Bears.
 * Created by alfergon on 30/01/17.
 */
public class TeddyBear extends Entity {

    public TeddyBear(Texture texture, float x, float y, Vector2 velocity, Sound teddyShot) {
        add(new PositionComponent(x, y));
        add(new VelocityComponent(velocity.x, velocity.y));
        add(new DrawableComponent(texture));
        add(BoundsBounceableComponent.singleton);
        add(worldBoundedComponent);
        add(new ShootingComponent(TEDDY_BEAR, -TEDDY_BEAR_PROJECTILE_OFFSET, teddyShot));
        add(new TimedShootingComponent(getInitialTimer(), BEAR_FIRING_RATE_RANGE));
        add(spawnableBearComponent);
        add(new DamageableComponent(GameConstants.FRENCH_FRIES_PROJECTILE_DAMAGE));
        add(EnemyComponent.enemyComponent);
    }

    protected float getInitialTimer() {
        return RandomNumberGenerator.nextFloat(-0.25f, 0.25f);
    }
}
