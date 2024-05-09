package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import static utils.Constants.PPM;

public class MyGdxGame extends ApplicationAdapter {
	private TextureAtlas atlas;
	private final float SCALE = 2.5f;

	private Box2DDebugRenderer b2dr;

	private OrthographicCamera camera;

	private World world;
	private PlayerManager player;

	private SpriteBatch batch;
	private Texture tex;

	Texture img;

	@Override
	public void create() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, w / SCALE, h / SCALE);

		world = new World(new Vector2(0, 0), false);
		b2dr = new Box2DDebugRenderer();
		player = new PlayerManager(world);
		player.run();

		batch = new SpriteBatch();
		tex = new Texture("tile000.png");

		atlas = new TextureAtlas("Player.atlas");

	}

	@Override
	public void render() {
		update(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin(); // Starts the rendering of the image
		batch.draw(tex, player.getPosition().x * PPM - (tex.getWidth() / 2),
				player.getPosition().y * PPM - (tex.getHeight() / 2));
		batch.end();

		b2dr.render(world, camera.combined.scl(PPM));
	}

	public TextureAtlas getAtlas() {
		return atlas;
	}

	@Override
	public void dispose() {
		world.dispose();
		batch.dispose();
		b2dr.dispose();
	}

	public void update(float delta) {
		world.step(1 / 60f, 6, 2);
		player.inputUpdate(delta);
		cameraUpdate(delta);
		batch.setProjectionMatrix(camera.combined);
	}


	public void cameraUpdate(float delta) {
		Vector2 position = player.getPosition();

		camera.position.set(position.x * PPM, position.y * PPM, 0);

		camera.update();
	}



	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false, width / SCALE, height / SCALE);
	}
}
