package au.com.ionprogramming.ld37;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sam on 11/12/2016.
 */
public class Text {

    private static char[] chars = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 's', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', ' ', ' ', ' ', ' ',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', '~', '`', ' ', ' ',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            ')', '!', '@', '#', '$', '%', '^', '&', '*', '(',
            '-', '+', '{', '}', '|', ':', '"', '<', '>', '?',
            '_', '=', '[', ']', '\\', ';', '\'', ',', '.', '/'
    };
    private static Texture charSheet;
    private static int screenX = 100;
    private static int screenY = 100;

    public static void load(){
        charSheet = new Texture("ld37font.png");
    }

    public static void drawCharacter(char c, int position, int line, SpriteBatch batch){
        int x = screenX + position*14;
        int y = screenY + line*18;
        int u = 0, v = 0;
        for(int n = 0; n < chars.length; n++){
            if(chars[n] == c){
                u = (n%10)*7;
                v = (n/10)*9;
            }
        }
//        batch.draw(charSheet, x, y, 12, 16, u, v, u + 6, v + 8);
        batch.draw(charSheet, x, y, 12, 16, 0, 0, 0.1f, 0.1f);
    }

}
