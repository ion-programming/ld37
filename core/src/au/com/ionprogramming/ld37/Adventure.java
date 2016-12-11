package au.com.ionprogramming.ld37;

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

    public void next(int ID){
        for(int i = 0; i < game.size(); i++){
            if(game.get(i).id == ID){
                currentScene = game.get(i);
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
}