package au.com.ionprogramming.ld37;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Lucas on 10/12/2016.
 */
public class Adventure {
    ArrayList<GameScene> game;
    GameScene currentScene;

    public Adventure(){
         game = new ArrayList<GameScene>();
    }

    public void addScene(GameScene g, int id){
        if(game.size() == 0){
            game.add(g);
        }
        for(int i = 0; i < game.size(); i++){
            if(game.get(i).id < id){
                game.add(i+1, g);
                break;
            }
        }
    }

    public void start(){
        for(int i = 0; i < game.size(); i++){
            if(game.get(i).id == 0){
                currentScene = game.get(i);
                currentScene.buildString();
                playSFX();
            }
        }
    }

    public void next(int select){
        int id = currentScene.next(select);
        if(id != currentScene.id) {
            for (int i = 0; i < game.size(); i++) {
                if (game.get(i).id == id) {
                    currentScene = game.get(i);
                    currentScene.buildString();
                    playSFX();
                }
            }
        }
    }

    public String getMessage(){
        return currentScene.message;
    }

    public void playSFX(){
        MusicManager.playSFX(currentScene.sfxPath);
    }

    public ArrayList<Option> getOptions(){
        return currentScene.options;
    }

    public void drawScene(SpriteBatch batch){
        currentScene.draw(batch);
    }
}