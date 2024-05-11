package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
<<<<<<< Updated upstream
import com.badlogic.gdx.utils.ScreenUtils;
=======
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ObjectMap;

>>>>>>> Stashed changes
import static utils.Constants.PPM;

public class MyGdxGame extends ApplicationAdapter {
	private TextureAtlas atlas;
	private final float SCALE = 2.5f;

	private float elapsedTime = 0f;
	private Box2DDebugRenderer b2dr;

	private OrthographicCamera camera;

	private World world;
	private PlayerManager player;

	private SpriteBatch batch;
	private Texture tex;
	private AssetManager assetManager;
	Texture img;
	private Skin skin;

	@Override
	public void create() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		assetManager = new AssetManager();
		initializeSkin();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w / SCALE, h / SCALE);

		world = new World(new Vector2(0, 0), false);
		b2dr = new Box2DDebugRenderer();
		player = new PlayerManager(world);
		player.run();

		batch = player.getBatch();


	}

	private void initializeSkin() {
		try {
			//generate sa font
			/*final ObjectMap<String, Object> resources = new ObjectMap<String, Object>();
			final FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("ui/font.ttf"));
			final FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
			fontParameter.minFilter = Texture.TextureFilter.Linear;
			fontParameter.magFilter = Texture.TextureFilter.Linear;
			final int[] sizesToCreate= {16,20,26,32};
			for(int size:sizesToCreate){
				fontParameter.size=size;
				resources.put("font_"+size,fontGenerator.generateFont(fontParameter));
			}
			fontGenerator.dispose();

			// load sa skin
			//final SkinLoader.SkinParameter skinParameter = new SkinLoader.SkinParameter("ui/hud.atlas", resources);
			//assetManager.load("ui/hud.json", Skin.class, skinParameter);
			assetManager.load("ui/hud.atlas", TextureAtlas.class);
			assetManager.finishLoading();*/

			//assetManager.finishLoading();
			//skin = assetManager.get("ui/hud.json", Skin.class);
			//skin = new Skin(Gdx.files.internal("ui/hud.json"), assetManager.get("ui/hud.atlas", TextureAtlas.class));
			skin = new Skin(Gdx.files.internal("ui/metal-ui.json"));

		} catch (Exception e) {
			Gdx.app.error("Skin Loading", "Error loading skin", e);
			e.printStackTrace(); // Print stack trace for more detailed error information
		}
	}
	@Override
	public void render() {
		update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(58 / 255f, 58 / 255f, 80 / 255f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		elapsedTime += Gdx.graphics.getDeltaTime();

		Animation<TextureRegion> currentAnimation = player.determineCurrentAnimation();
		TextureRegion currentFrame = currentAnimation.getKeyFrame(elapsedTime, true); // 'true' for looping

//		batch.draw(currentFrame, player.getPosition().x * PPM , player.getPosition().y * PPM);



		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		batch.draw(currentFrame, player.getPosition().x * PPM - ((float) currentFrame.getRegionWidth() / 2), player.getPosition().y * PPM - ((float) currentFrame.getRegionHeight() / 8));
		// stove render
		batch.end();

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}


//		update(Gdx.graphics.getDeltaTime());
//		Animation<TextureRegion> currentAnimation = player.determineCurrentAnimation();
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin(); // Starts the rendering of the image
//
//
////		batch.draw(tex, player.getPosition().x * PPM - (tex.getWidth() / 2),player.getPosition().y * PPM - (tex.getHeight() / 2));
//		batch.end();
//
//		b2dr.render(world, camera.combined.scl(PPM));
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
