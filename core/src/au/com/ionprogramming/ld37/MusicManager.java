package au.com.ionprogramming.ld37;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Lucas on 11/12/2016.
 */
public class MusicManager {

//    private static Music bg = Gdx.audio.newMusic(Gdx.files.internal("music/SWAGGER STAGGER.mp3"));
    private static Sound sound;

//    public static void playMusic(){
//        bg.play();
//    }

    public static void playSFX(String path){
        if(path != null) {
            sound = Gdx.audio.newSound(Gdx.files.internal("sfx/" + path));
            sound.play();
        }
    }
}
