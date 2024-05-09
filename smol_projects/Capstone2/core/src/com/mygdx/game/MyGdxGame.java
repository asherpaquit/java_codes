package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import static utils.Constants.PPM;

public class MyGdxGame extends ApplicationAdapter {

	private Box2DDebugRenderer b2dr;

	private OrthographicCamera camera;

	private World world;
	private Body player;



	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, w / 2, h /2 );

		world = new World(new Vector2(0,-9.8f), false);
		b2dr = new Box2DDebugRenderer();

		player = createPlayer(2, 10, 32, 32, false);
		player = createPlayer(0, 0, 32, 32, true);

		batch = new SpriteBatch();

	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());


		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();

		b2dr.render(world, camera.combined.scl(PPM));
	}
	
	@Override
	public void dispose () {
		world.dispose();
		batch.dispose();
		b2dr.dispose();
	}


	public void update(float delta){
		world.step(1 / 60f, 6, 2);
		inputUpdate(delta);
		cameraUpdate(delta);
	}

	public void inputUpdate(float delta){
		int horizontalForce = 0;

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			horizontalForce -= 1;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			horizontalForce += 1;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			player.applyForceToCenter(0, 300, false);
		}

		player.setLinearVelocity(horizontalForce * 5, player.getLinearVelocity().y);
	}

	public void cameraUpdate(float delta){
		Vector3 position = camera.position;

		position.x = player.getPosition().x * PPM;
		position.y = player.getPosition().y * PPM;
		camera.position.set(position);

		camera.update();
	}

	public Body createPlayer(int x, int y, int width, int height, boolean isStatic){
		Body pBody;
		BodyDef def = new BodyDef();

		if(isStatic){
			def.type = BodyDef.BodyType.StaticBody;

		}
		else{
			def.type = BodyDef.BodyType.DynamicBody;
		}

//		def.type = BodyDef.BodyType.DynamicBody;
		def.position.set(x / PPM, y / PPM);
		def.fixedRotation = true;
		pBody = world.createBody(def);


		PolygonShape shape = new PolygonShape();
		shape.setAsBox(32 / 2 / PPM, 32 / 2 / PPM);

		pBody.createFixture(shape, 1.0f);
		shape.dispose();


		return pBody;
	}
}
