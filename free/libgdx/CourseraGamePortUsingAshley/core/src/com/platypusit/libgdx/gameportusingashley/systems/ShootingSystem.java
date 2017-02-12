package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.platypusit.libgdx.gameportusingashley.ComponentMappers;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;
import com.platypusit.libgdx.gameportusingashley.components.ShootingComponent;
import com.platypusit.libgdx.gameportusingashley.entities.FrenchFriesProjectile;
import com.platypusit.libgdx.gameportusingashley.entities.GummyBearProjectile;

/**
 * <p>System for shooting projectiles, it will create the projectile entity, add it to the engine and play de shooting sound.</p>
 * <p>After shooting, it will set the {@link ShootingComponent#isShooting} flag to {@code false}.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class ShootingSystem extends IteratingSystem {

    private static final Family family = Family.all(PositionComponent.class, ShootingComponent.class).get();

    public ShootingSystem() {
        super(family);
    }

    public ShootingSystem(int priority) {
        super(family, priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        ShootingComponent shooter = ComponentMappers.shooting.get(entity);

        if (shooter.isShooting) {
            Entity projectile;

            // stop shooting
            shooter.isShooting = false;

            // prepare the initial position of the projectile
            PositionComponent position = ComponentMappers.position.get(entity);
            float projectileX = position.x;
            float projectileY = position.y + shooter.projectileSpawningYOffset;

            // create projectile entity depending on its type
            switch (shooter.projectileType) {
                case TEDDY_BEAR:
                    projectile = new GummyBearProjectile(projectileX, projectileY);
                    break;
                default:
                    projectile = new FrenchFriesProjectile(projectileX, projectileY);
                    break;
            }

            // play shooting sound
            shooter.firingSound.play(1);

            // add projectile entity to engine
            getEngine().addEntity(projectile);
        }
    }
}
