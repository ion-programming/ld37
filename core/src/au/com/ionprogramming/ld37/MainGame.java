package au.com.ionprogramming.ld37;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends ApplicationAdapter {
	SpriteBatch batch;

	Texture bg;
	Texture laptop;

	Adventure a;
	@Override
	public void create () {
		batch = new SpriteBatch();

		bg = new Texture("bg.png");
		laptop = new Texture("laptop.png");

		Loader l = new Loader();
		a = l.loadGame("adventure.txt");
		a.next(0);
		Text.load();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
//		batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		batch.draw(laptop, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Text.drawCharacter('P', 0, 0, batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bg.dispose();
		laptop.dispose();
	}
}
