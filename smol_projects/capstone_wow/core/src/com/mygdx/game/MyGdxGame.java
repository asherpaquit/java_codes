package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.sun.org.apache.bcel.internal.Const;
import utils.Constants;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion[] animationFrames;
	Animation animation;
	float elapsedTime;



	private Box2DDebugRenderer b2dr;
	private World world;
	private Body player, platform;
	private OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("character.png");

		TextureRegion[][] tmpFrames = TextureRegion.split(img,16,16);

		animationFrames = new TextureRegion[28];
		int index = 0;
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 2; j++){
				animationFrames[index++] = tmpFrames[j][i];
			}
		}

		animation = new Animation(1f/4f, animationFrames);

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, w / 2, h /2 );

		world = new World(new Vector2(0, -9.8f), false);
		b2dr = new Box2DDebugRenderer();

		player = createBox(0, 10, 20, 20, false);
		platform = createBox(0, 0, 16, 16, true);
	}

	@Override
	public void resize(int width, int height){
		camera.setToOrtho(false, width / 2, height / 2);
	}

	@Override
	public void render () {
		elapsedTime += Gdx.graphics.getDeltaTime();
//		update(Gdx.graphics.getDeltaTime());



		Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		b2dr.render(world, camera.combined.scl(Constants.PPM));
		batch.begin();
		batch.draw((Texture) animation.getKeyFrame(elapsedTime,true),0.2,0.2);
		batch.end();
	}

	@Override
	public void dispose () {
		world.dispose();
		b2dr.dispose();
		batch.dispose();
		img.dispose();
	}

	public void update(float delta){
		world.step(1 / 60f, 6, 2);
		cameraUpdate(delta);
		inputUpdate(delta);
	}

	public Body createBox(int x, int y, int width, int height, boolean isStatic){
		Body pBody;
		BodyDef def = new BodyDef();

		if(isStatic){
			def.type = BodyDef.BodyType.StaticBody;
		}
		else{
			def.type = BodyDef.BodyType.DynamicBody;
		}
		def.position.set(x / Constants.PPM, y / Constants.PPM);
		def.fixedRotation = true;
		pBody = world.createBody(def);

		PolygonShape shape =  new PolygonShape();
		shape.setAsBox(width / 2 / Constants.PPM, height / 2 / Constants.PPM);

		pBody.createFixture(shape, 1.0f);
		shape.dispose();
		return pBody;
	}

	public void inputUpdate(float delta){
		int horizontalForce = 0;
		int verticalForce = 0;

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
		verticalForce += 1;

		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
		verticalForce -= 1;

		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			horizontalForce -= 1;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			horizontalForce += 1;
		}

		player.setLinearVelocity(horizontalForce * 5, player.getLinearVelocity().y);
		player.setLinearVelocity(verticalForce * 5, player.getLinearVelocity().x);
	}

	public void cameraUpdate(float delta){
		Vector3 position = camera.position;
		position.x = player.getPosition().x * Constants.PPM;
		position.y = player.getPosition().y * Constants.PPM;
		camera.position.set(position);

		camera.update();
	}

//	public Body createBox(){
//		Body pBody;
//		BodyDef def = new BodyDef();
//		def.type = BodyDef.BodyType.DynamicBody;
//		def.position.set(0, 0);
//		def.fixedRotation = true;
//		pBody = world.createBody(def);
//
//		PolygonShape shape =  new PolygonShape();
//		shape.setAsBox(32 / 2 / Constants.PPM, 32 / 2 / Constants.PPM);
//
//		pBody.createFixture(shape, 1.0f);
//		shape.dispose();
//		return pBody;
//	}
}
