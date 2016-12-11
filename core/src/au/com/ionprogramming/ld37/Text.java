package au.com.ionprogramming.ld37;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sam on 11/12/2016.
 */
public class Text {

    private static char[] chars = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
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
    private static int screenX = 142;
    private static int screenY = 166;

    public static void load(){
        charSheet = new Texture("ld37font.png");
    }

    public static void drawCharacter(char c, int position, int line, SpriteBatch batch){
        int x = screenX + position*10;
        int y = screenY + line*14;
        float u = 0, v = 0;
        for(int n = 0; n < chars.length; n++){
            if(chars[n] == c){
                u = (n%10)*0.1f;
                v = (n/10)*0.1f;
            }
        }
        batch.draw(charSheet, x, y, 9, 13, u, v + 0.1f, u + 0.1f, v);
    }

    public static void drawString(String s, SpriteBatch batch){
        int position = 0, line = 16;
        boolean temp = false, wrapped = false;
        for(int n = 0; n < s.length(); n++){
            if(line < 0) return;
            char c = s.charAt(n);
            if(c == '\n' && !wrapped){
                line--;
                position = 0;
            }
            else if(c != '\n' && !(wrapped && c == ' ')){
                drawCharacter(c, position, line, batch);
                if(position < 41) position++;
                else {
                    line--;
                    position = 0;
                    temp = true;
                }
                wrapped = temp;
            }
            temp = false;
        }
    }

}
