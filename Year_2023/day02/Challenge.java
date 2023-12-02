package day02;

import java.io.File;
import java.util.Scanner;
import java.util.regex.*;
import day02.paths;

public class Challenge {

    public static void main(String[] args) throws Exception {
        // pass the path to the file as a parameter
        File file = new File(day02.paths.input);
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            int gameNumber = 0;
            boolean gotNumber = false;
            while (!gotNumber) {
                for (char chara : line.toCharArray()) {
                    try {
                        gameNumber = Integer.valueOf(chara);
                    } catch (Exception e) {
                        continue;
                    }
                    gotNumber = true;
                    break;
                }
            }
            String[] splitted = line.split(";");
            System.out.println(splitted);
        }
    }

}