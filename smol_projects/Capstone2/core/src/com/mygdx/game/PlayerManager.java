package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

import static utils.Constants.PPM;

public class PlayerManager implements Runnable{
    public enum State {STANDING, RUNNING};
    public State currentState;
    public State previousState;

    private Animation playerRun;
    private boolean runningRight;
    private float stateTimer;



    private World world;
    static Body player, real_player;
    private TextureAtlas textureAtlas;
    private SpriteBatch playerBatch;
    private Map<String, Animation<TextureRegion>> animations = new HashMap<>();


    @Override
    public void run(){
        player = createPlayer(2, 10, 32, 32, true);
        real_player = createPlayer(0, 0, 64, 64, false);
        playerBatch = new SpriteBatch();

    }

    public PlayerManager(World world) {
        this.world = world;
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 1;i <= 12; i+=4){
            frames.add(new TextureRegion(getTexture(), i * 16, 0, ));
        }

    }
    public Body createPlayer(int x, int y, int width, int height, boolean isStatic) {
        Body pBody;
        BodyDef def = new BodyDef();

        if (isStatic) {
            def.type = BodyDef.BodyType.DynamicBody;

        } else {
            def.type = BodyDef.BodyType.StaticBody;
        }

        // def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(x / PPM, y / PPM);
        def.fixedRotation = true;
        pBody = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(16 / 2 / PPM, 16 / 2 / PPM);

        pBody.createFixture(shape, 1.0f);
        shape.dispose();

        return pBody;
    }

    public void inputUpdate(float delta) {
        int horizontalForce = 0;
        int verticalForce = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            horizontalForce -= 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            horizontalForce += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            verticalForce += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            verticalForce -= 1;
        }

        player.setLinearVelocity(horizontalForce * 5, verticalForce * 5);
    }

    public Vector2 getPosition() {
        return player.getPosition();
    }


}
