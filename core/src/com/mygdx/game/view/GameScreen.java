package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.model.Gay;
import com.mygdx.game.utils.UI;

public class GameScreen implements Screen {

    private TextureAtlas textureAtlas;
    private SpriteBatch batch;
    private Gay gay;
    private OrthographicCamera camera;
    private UI ui;

    public static float deltaCff;

    @Override
    public void show() {
        batch = new SpriteBatch();
        gay = new Gay(textureAtlas.findRegion("0"),0f,0f,3f,3f * 1.18f);
        ui = new UI();

        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0.3f,0,1);
        Gdx.gl.glClearDepthf(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
            gay.draw(batch);
        batch.end();

        ui.draw();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / width;
        camera = new OrthographicCamera(20f, 20f * aspectRatio);
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
        batch.dispose();
        ui.dispose();
    }
}
