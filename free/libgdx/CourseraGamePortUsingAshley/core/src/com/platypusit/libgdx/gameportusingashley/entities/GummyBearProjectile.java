package com.platypusit.libgdx.gameportusingashley.entities;

import com.badlogic.gdx.graphics.Texture;

import static com.platypusit.libgdx.gameportusingashley.constant.GameConstants.TEDDY_BEAR_PROJECTILE_SPEED;

/**
 * <p>Entity for projectile shoot off teddy bears.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class GummyBearProjectile extends Projectile {

    private static Texture projectileTexture;

    public static void setProjectileTexture(Texture texture){
        projectileTexture = texture;
    }

    public GummyBearProjectile(float x, float y) {
        super(x, y, -TEDDY_BEAR_PROJECTILE_SPEED, projectileTexture);
    }
}
