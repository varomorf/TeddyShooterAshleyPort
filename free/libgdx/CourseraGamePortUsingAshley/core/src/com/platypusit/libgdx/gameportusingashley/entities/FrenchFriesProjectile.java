package com.platypusit.libgdx.gameportusingashley.entities;

import com.badlogic.gdx.graphics.Texture;
import com.platypusit.libgdx.gameportusingashley.components.EnemyComponent;
import com.platypusit.libgdx.gameportusingashley.constant.GameConstants;

import static com.platypusit.libgdx.gameportusingashley.constant.GameConstants.FRENCH_FRIES_PROJECTILE_SPEED;

/**
 * <p>Entity for projectile shoot off teddy bears.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class FrenchFriesProjectile extends Projectile {

    private static Texture projectileTexture;

    public static void setProjectileTexture(Texture texture){
        projectileTexture = texture;
    }

    public FrenchFriesProjectile(float x, float y) {
        super(x, y, FRENCH_FRIES_PROJECTILE_SPEED, projectileTexture, GameConstants.FRENCH_FRIES_PROJECTILE_DAMAGE, EnemyComponent.class);
    }
}
