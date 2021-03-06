package au.com.ionprogramming.ld37;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;

	Texture bg;
	Texture laptop;

	Adventure a;

	int lightState = 1;
	int timer = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();

		shapeRenderer = new ShapeRenderer();

		shapeRenderer.setAutoShapeType(true);

		bg = new Texture("bg.png");
		laptop = new Texture("laptop.png");

		Loader l = new Loader();
		a = l.loadGame("adventure.txt");
		a.start();

		Text.load();
		MusicManager.playMusic();
	}

	@Override
	public void render () {
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_1)) a.next(1);
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_2)) a.next(2);
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_3)) a.next(3);
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_4) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_4)) a.next(4);
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_5) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_5)) a.next(5);
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_6) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_6)) a.next(6);
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_7) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_7)) a.next(7);
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_8) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_8)) a.next(8);
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_9) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_9)) a.next(9);

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(laptop, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		a.drawScene(batch);
		batch.end();

		timer++;
		if(timer >= 10){
			timer = 0;
			lightState++;
			if (lightState > 3){
				lightState = 1;
			}
		}

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
			switch (lightState){
				case 1:
					shapeRenderer.setColor(Color.RED);
					shapeRenderer.rect(572, 28, 4, 8);
					shapeRenderer.setColor(Color.BLUE);
					shapeRenderer.rect(584, 28, 4, 8);
					shapeRenderer.setColor(Color.GREEN);
					shapeRenderer.rect(600, 28, 4, 8);
					break;
				case 2:
					shapeRenderer.setColor(Color.GREEN);
					shapeRenderer.rect(572, 28, 4, 8);
					shapeRenderer.setColor(Color.RED);
					shapeRenderer.rect(584, 28, 4, 8);
					shapeRenderer.setColor(Color.BLUE);
					shapeRenderer.rect(600, 28, 4, 8);
					break;
				case 3:
					shapeRenderer.setColor(Color.BLUE);
					shapeRenderer.rect(572, 28, 4, 8);
					shapeRenderer.setColor(Color.GREEN);
					shapeRenderer.rect(584, 28, 4, 8);
					shapeRenderer.setColor(Color.RED);
					shapeRenderer.rect(600, 28, 4, 8);
					break;
			}

		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bg.dispose();
		laptop.dispose();
	}
}
