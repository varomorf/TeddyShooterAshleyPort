package com.platypusit.libgdx.gameportusingashley;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platypusit.libgdx.gameportusingashley.entities.TeddyBear;
import com.platypusit.libgdx.gameportusingashley.systems.DrawingSystem;

public class CourseraGamePortUsingAshley extends ApplicationAdapter {

	private Engine engine;

	private Texture teddyBearTexture;

	private SpriteBatch batch;

	@Override
	public void create () {
		engine = new Engine();
		batch = new SpriteBatch();

		// load textures
		teddyBearTexture = new Texture(TeddyBear.TEXTURE_PATH);

		// create test bear
		Entity teddyBear = new TeddyBear(teddyBearTexture);
		engine.addEntity(teddyBear);

		// add drawing system
        DrawingSystem drawingSystem = new DrawingSystem(batch);
        engine.addSystem(drawingSystem);
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
}
