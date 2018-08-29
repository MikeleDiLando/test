package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.Gay;

public class GameScreen implements Screen {

    private Texture gayTexture;
    private SpriteBatch batch;
    private Gay gay;

    @Override
    public void show() {
        gayTexture = new Texture(Gdx.files.internal("gay.png"));
        batch = new SpriteBatch();
        gay = new Gay(gayTexture,60,20,5,10);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClearDepthf(GL20.GL_DEPTH_ATTACHMENT);

        batch.begin();
            batch.draw(gayTexture, 0,0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

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
