package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.Gay;

public class GameScreen implements Screen {

    private Texture gayTexture;
    private SpriteBatch batch;
    private Gay gay;
    private OrthographicCamera camera;

    public static float deltaCff;

    @Override
    public void show() {
        gayTexture = new Texture(Gdx.files.internal("gay.png"));
        batch = new SpriteBatch();
        gayTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        gay = new Gay(gayTexture,0,0,3f,3f * 1.18f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClearDepthf(GL20.GL_DEPTH_ATTACHMENT);

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
            gay.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRation = (float) height / width;
        camera = new OrthographicCamera(20f, 20f * aspectRation);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        gayTexture.dispose();

    }
}
