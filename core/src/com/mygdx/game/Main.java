package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.utils.Assets;
import com.mygdx.game.view.GameScreen;

public class Main extends Game {

	private Screen gameScree;
	private Assets assets;

	@Override
	public void create() {
		assets = new Assets();
		gameScree = new GameScreen();
		((GameScreen)gameScree).setTextureAtlas(assets.getManager().get("atlas1.atlas", TextureAtlas.class));
		setScreen(gameScree);
	}

	@Override
	public void dispose() {
		super.dispose();
		gameScree.dispose();
		assets.dispose();
	}
}
