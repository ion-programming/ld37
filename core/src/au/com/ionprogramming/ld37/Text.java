package au.com.ionprogramming.ld37;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    private static int width = 42;
    private static int lines = 16;

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

    public static String preProcess(String s){
        ArrayList<String> lineList = new ArrayList<String>();
        lineList.addAll(Arrays.asList(s.split("\n")));
        for(int n = 0; n < lineList.size(); n++){
            if(lineList.get(n).length() > width){
                char c1 = lineList.get(n).charAt(width - 1);
                char c2 = lineList.get(n).charAt(width);
                if(c1 != ' ' && c1 != '-' && c2 != ' ' && c2 != '-'){
                    int i1 = lineList.get(n).lastIndexOf(' ', width);
                    int i2 = lineList.get(n).lastIndexOf('-', width);
                    i1 = i1 > i2? i1 : i2;
                    if(i1 >= 0){
                        lineList.add(n + 1, lineList.get(n).substring(i1).trim());
                        lineList.set(n, lineList.get(n).substring(0, i1));
                    }
                }
                else{
                    lineList.add(n + 1, lineList.get(n).substring(width).trim());
                    lineList.set(n, lineList.get(n).substring(0, width));
                }
            }
        }
        s = "";
        for(int n = 0; n < lineList.size(); n++){
            s += lineList.get(n) + '\n';
        }
        return s;
    }

    public static void drawString(String s, SpriteBatch batch){
        int position = 0, line = lines;
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
                if(position < width - 1) position++;
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
