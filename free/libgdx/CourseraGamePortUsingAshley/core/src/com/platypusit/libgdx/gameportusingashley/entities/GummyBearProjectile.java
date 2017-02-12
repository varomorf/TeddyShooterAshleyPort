package com.platypusit.libgdx.gameportusingashley.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;
import com.platypusit.libgdx.gameportusingashley.components.VelocityComponent;
import com.platypusit.libgdx.gameportusingashley.constant.GameConstants;

/**
 * <p>Entity for projectile shoot off teddy bears.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class GummyBearProjectile extends Entity{

    private static Texture projectileTexture;

    public static void setProjectileTexture(Texture texture){
        projectileTexture = texture;
    }

    public GummyBearProjectile(float x, float y) {
        add(new PositionComponent(x, y));
        add(new VelocityComponent(0, -GameConstants.TEDDY_BEAR_PROJECTILE_SPEED));
    }
}
