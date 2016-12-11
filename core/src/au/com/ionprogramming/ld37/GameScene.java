package au.com.ionprogramming.ld37;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Lucas on 11/12/2016.
 */
public class GameScene{
    int id;
    String message;
    ArrayList<Option> options = new ArrayList<Option>();
    String sfxPath;

    public GameScene(int id, String message){
        this.id = id;
        this.message = message;
    }

    public void setSfxPath(String p){
        sfxPath = p;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void addOption(String text, int goTo){
        options.add(new Option(text, goTo));
    }

    public void draw(SpriteBatch batch){
        String s = message + '\n';
        for (int n = 0; n < options.size(); n++) {
            s += (n + 1) + "-" + options.get(n).note + '\n';
        }
        Text.drawString(s, batch);
    }

    public int next(int select){
        if(options.size() >= select){
            return options.get(select - 1).goTo;
        }
        return id;
    }
}

class Option{
    String note;
    int goTo;

    public Option(String text, int goTo){
        this.note = text;
        this.goTo = goTo;
    }
}
