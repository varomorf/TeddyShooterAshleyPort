package com.platypusit.libgdx.gameportusingashley;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.platypusit.libgdx.gameportusingashley.constant.GameConstants;
import com.platypusit.libgdx.gameportusingashley.entities.Burger;
import com.platypusit.libgdx.gameportusingashley.entities.FrenchFriesProjectile;
import com.platypusit.libgdx.gameportusingashley.entities.GummyBearProjectile;
import com.platypusit.libgdx.gameportusingashley.entities.TeddyBear;
import com.platypusit.libgdx.gameportusingashley.systems.*;

import static com.platypusit.libgdx.gameportusingashley.constant.GameConstants.*;

public class CourseraGamePortUsingAshley extends ApplicationAdapter {

	private Engine engine;

	private SpriteBatch batch;

    private static Texture explosionSpriteStrip;

    private BitmapFont bitmapFont;

    // scoring support
    private int score = 0;
    private String scoreString = GameConstants.SCORE_PREFIX + 0;

    // health support
    private String healthString = GameConstants.HEALTH_PREFIX + GameConstants.BURGER_INITIAL_HEALTH;
    private boolean burgerDead = false;

    // sound effects
    Sound burgerDamage;
    Sound burgerDeath;
    Sound explosion;

	@Override
	public void create () {
		engine = new Engine();
		batch = new SpriteBatch();

		// load textures
        Texture burgerTexture = new Texture("graphics/burger.png");
        Texture teddyBearTexture = new Texture("graphics/teddybear.png");
        Texture teddyBearProjectileSprite = new Texture("graphics/teddybearprojectile.png");
        Texture frenchFriesSprite = new Texture("graphics/frenchfries.png");
        explosionSpriteStrip = new Texture("graphics/explosion.png");

        // load audio content
        burgerDamage = Gdx.audio.newSound(Gdx.files.internal("audio/BurgerDamage.wav"));
        burgerDeath = Gdx.audio.newSound(Gdx.files.internal("audio/BurgerDeath.wav"));
        Sound burgerShot = Gdx.audio.newSound(Gdx.files.internal("audio/BurgerShot.wav"));
        explosion = Gdx.audio.newSound(Gdx.files.internal("audio/Explosion.wav"));
        Sound teddyBounce = Gdx.audio.newSound(Gdx.files.internal("audio/TeddyBounce.wav"));
        Sound teddyShot = Gdx.audio.newSound(Gdx.files.internal("audio/TeddyShot.wav"));

        // set projectile textures
        GummyBearProjectile.setProjectileTexture(teddyBearProjectileSprite);
        FrenchFriesProjectile.setProjectileTexture(frenchFriesSprite);

        // add the player's burger to the engine
        engine.addEntity(new Burger(burgerTexture, burgerShot));

		// add systems
        engine.addSystem(getBearSpawningSystem(teddyBearTexture, teddyShot));
        engine.addSystem(new TimedShootingSystem());
        engine.addSystem(new ShootingSystem());
        engine.addSystem(new PlayerControlSystem());
        engine.addSystem(new MovementSystem());
        engine.addSystem(new BoundingSystem());
        engine.addSystem(new BoundsBouncingSystem(teddyBounce));
        engine.addSystem(new DrawingSystem(batch));
	}

    @Override
	public void render () {
		float deltaSeconds = Gdx.graphics.getDeltaTime();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		engine.update(deltaSeconds);

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	private EntitySystem getBearSpawningSystem(Texture teddyBearTexture, Sound teddyShot){
	    BearSpawnSystem system = new BearSpawnSystem();

	    system.setTeddyBearTexture(teddyBearTexture);
	    system.setTeddyShot(teddyShot);

	    return system;
    }

}
