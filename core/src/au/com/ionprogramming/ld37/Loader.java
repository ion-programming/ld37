package au.com.ionprogramming.ld37;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Created by Lucas on 10/12/2016.
 */
public class Loader {

    public Adventure loadGame(String file){
        Adventure a = new Adventure();

        Scanner in = null;
        try {
            in = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        GameScene g = new GameScene(1, "");

        int stage = 0; //0 - id,
        int ID = 0;

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();

            switch(stage) {
                case 0:
                    if (line.startsWith("#")) {
                        ID = Integer.parseInt(line.substring(1));
                        stage = 1;
                    } else if (line.startsWith("?")) {
                        ID = Integer.parseInt(line.substring(1));
                        stage = 2;
                    } else if (line.isEmpty()){
                        a.addScene(g, g.id);
                    }
                    break;
                case 1:
                    g = new GameScene(ID, line);
                    stage = 0;
                    break;
                case 2:
                    g.addOption(line, ID);
                    stage = 0;
                    break;
            }
        }

        return a;
    }
}
