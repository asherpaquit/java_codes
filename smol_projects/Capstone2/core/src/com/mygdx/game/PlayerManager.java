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
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import static utils.Constants.PPM;

public class PlayerManager implements Runnable{
    public enum State {STANDING, RUNNING};

    private String lastDirection;
    public State currentState;
    public State previousState;

    private Animation playerRun;
    private boolean runningRight;
    private float stateTimer;

//    private Animation<TextureRegion> animation_walking;
    private Map<String, Animation<TextureRegion>> animations = new HashMap<>();
    private World world;
    static Body player, real_player;
    private TextureAtlas textureAtlas;
    private SpriteBatch playerBatch;


    @Override
    public void run(){
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;
        lastDirection = "down";

        textureAtlas = new TextureAtlas(Gdx.files.internal("assets/Player.atlas"));
        player = createPlayer(2, 10, 32, 32, true);
        real_player = createPlayer(0, 0, 64, 64, false);
        playerBatch = new SpriteBatch();
        animations = new HashMap<>();

        animations.put("running_down",new Animation<>(0.1f,textureAtlas.findRegions("walk_down")));
        animations.put("running_up",new Animation<>(0.1f,textureAtlas.findRegions("walk_up")));
        animations.put("running_right",new Animation<>(0.1f,textureAtlas.findRegions("walk_right")));
        animations.put("running_left",new Animation<>(0.1f,textureAtlas.findRegions("walk_left")));

        animations.put("idle_up",new Animation<>(0.1f,textureAtlas.findRegions("idle_up")));
        animations.put("idle_left",new Animation<>(0.1f,textureAtlas.findRegions("idle_left")));
        animations.put("idle_right",new Animation<>(0.1f,textureAtlas.findRegions("idle_right")));
        animations.put("idle_down",new Animation<>(0.1f,textureAtlas.findRegions("idle_down")));

        initializeAnimations();
//        animation_walking = new Animation<TextureRegion>(0.1f);
//        Array<TextureAtlas.AtlasRegion> walkingFrame = textureAtlas.findRegions("walk_down");
    }

    public PlayerManager(World world) {

        this.world = world;
//        currentState = State.STANDING;
//        previousState = State.STANDING;
//        stateTimer = 0;
//        runningRight = true;

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

    public Animation<TextureRegion> determineCurrentAnimation(){
            String lastDir = getLastDirection();
            // If movement keys are pressed, return the corresponding running animation
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                setLastDirection("up");

                return animations.get("running_up");
            } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                setLastDirection("left");
                return animations.get("running_left");
            } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                setLastDirection("down");

                return animations.get("running_down");
            } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){ // Gdx.input.isKeyPressed(Input.Keys.D)

                setLastDirection("right");

                return animations.get("running_right");
            }else {
                // If no movement keys are pressed, return the corresponding idle animation

                return animations.get("idle_" + lastDir);
            }

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

    public void setLastDirection(String direction) {
        this.lastDirection = direction;
    }

    public String getLastDirection() {
        return lastDirection;
    }

    public Vector2 getPosition() {
        return player.getPosition();
    }

    private void initializeAnimations(){

    }

    public SpriteBatch getBatch(){
        return playerBatch;
    }
}
