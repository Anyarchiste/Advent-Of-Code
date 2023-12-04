package day03;

import day03.paths;
import java.io.File;
import java.util.Scanner;
import java.util.Dictionary;

/**
 * Challenge
 */
public class Challenge {

    public static void main(String[] args) throws Exception {

        Scanner input = readFile();

        getSpecialCharacter(input);

        while (input.hasNextLine()) {

        }
    }

    public static Scanner readFile() throws Exception {
        File file;
        file = new File(day03.paths.puzzle);
        
        Scanner input = new Scanner(file);

        return input;
    }

    public static char[] getSpecialCharacter(Scanner input) {
        char[] ret = new char[6];

        while (input.hasNextLine()) {
            String line = input.nextLine();

            line = line.replaceAll("[0-9]*[\\.]*", "");
        }

        return ret;
    }
}