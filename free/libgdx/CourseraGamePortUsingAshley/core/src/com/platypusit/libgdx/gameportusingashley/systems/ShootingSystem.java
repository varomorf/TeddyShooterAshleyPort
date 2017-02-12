package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.platypusit.libgdx.gameportusingashley.ComponentMappers;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;
import com.platypusit.libgdx.gameportusingashley.components.ShootingComponent;
import com.platypusit.libgdx.gameportusingashley.entities.GummyBearProjectile;

/**
 * <p>System for shooting projectiles, it will create the projectile entity, add it to the engine and play de shooting sound.</p>
 * <p>After shooting, it will set the {@link ShootingComponent#isShooting} flag to {@code false}.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class ShootingSystem extends IteratingSystem {

    private static final Family family = Family.all(PositionComponent.class, ShootingComponent.class).get();

    private Engine engine;

    public ShootingSystem(Engine engine) {
        super(family);
        this.engine = engine;
    }

    public ShootingSystem(int priority, Engine engine) {
        super(family, priority);
        this.engine = engine;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        ShootingComponent shooter = ComponentMappers.shooting.get(entity);

        if (shooter.isShooting) {
            Entity projectile;
            PositionComponent position = ComponentMappers.position.get(entity);

            float projectileX = position.x;
            float projectileY = position.y + shooter.projectileSpawningYOffset;

            switch (shooter.projectileType) {
                case TEDDY_BEAR:
                    projectile = new GummyBearProjectile(projectileX, projectileY);
                    break;
                default:
                    projectile = null; //TODO change to player projectile
                    break;
            }

            engine.addEntity(projectile);
        }
    }
}
