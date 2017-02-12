package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.platypusit.libgdx.gameportusingashley.RandomNumberGenerator;
import com.platypusit.libgdx.gameportusingashley.components.SpawnableBearComponent;
import com.platypusit.libgdx.gameportusingashley.constant.GameConstants;
import com.platypusit.libgdx.gameportusingashley.entities.TeddyBear;

import static com.platypusit.libgdx.gameportusingashley.constant.GameConstants.*;
import static com.platypusit.libgdx.gameportusingashley.constant.GameConstants.MIN_BEAR_SPEED;

/**
 * <p>System for spawning bear entities.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class BearSpawnSystem extends EntitySystem{

    private float timer;

    private Texture teddyBearTexture;
    private Sound teddyShot;

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        timer += deltaTime;
        if(timer >= GameConstants.SPAWN_RATIO){
            int numOfBears = getEngine().getEntitiesFor(Family.all(SpawnableBearComponent.class).get()).size();
            if(numOfBears < GameConstants.MAX_BEARS){
                spawnBear();
                timer = 0;
            }
        }

    }

    private void spawnBear() {
        // generate random location
        int bearX = getRandomLocation(SPAWN_BORDER_SIZE, WINDOW_WIDTH - SPAWN_BORDER_SIZE);
        int bearY = getRandomLocation(SPAWN_BORDER_SIZE, WINDOW_HEIGHT - SPAWN_BORDER_SIZE);

        // generate random velocity and create a vector with it
        float velMagnitude = RandomNumberGenerator.nextFloat(BEAR_SPEED_RANGE);
        if (velMagnitude < MIN_BEAR_SPEED) {
            velMagnitude = MIN_BEAR_SPEED;
        }
        float velAngle = RandomNumberGenerator.nextFloat((float) (2 * Math.PI));
        float velX = (float) (velMagnitude * Math.cos(velAngle));
        float velY = (float) (velMagnitude * Math.sin(velAngle));
        Vector2 bearVelocity = new Vector2(velX, velY);

        // add new bear to engine
        getEngine().addEntity(new TeddyBear(teddyBearTexture, bearX, bearY, bearVelocity, teddyShot));
    }

    /**
     * Gets a random location using the given min and range
     *
     * @param min   the minimum
     * @param range the range
     * @return the random location
     */
    private int getRandomLocation(int min, int range) {
        return min + RandomNumberGenerator.next(range);
    }

    public void setTeddyBearTexture(Texture teddyBearTexture) {
        this.teddyBearTexture = teddyBearTexture;
    }

    public void setTeddyShot(Sound teddyShot) {
        this.teddyShot = teddyShot;
    }
}
