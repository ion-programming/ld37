package au.com.ionprogramming.ld37;

import java.util.ArrayList;

/**
 * Created by Lucas on 11/12/2016.
 */
public class GameScene{
    int id;
    String message;
    ArrayList<Option> options = new ArrayList<Option>();

    public GameScene(int id, String message){
        this.id = id;
        this.message = message;
    }

    public void addOption(String text, int goTo){
        options.add(new Option(text, goTo));
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
