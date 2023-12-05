package day03;

import day03.paths;
import java.io.File;
import java.util.Scanner;

/**
 * Challenge
 */
public class Challenge {

    public static void main(String[] args) throws Exception {

        Scanner input = readFile();

        char[][] matrix = new char[10][10]; //140 - 140

        int indexWhile = 0;
        while (input.hasNextLine()) {
            char[] line = input.nextLine().toCharArray();
            for (int i = 0; i < line.length; i++) {
                matrix[indexWhile][i] = line[i];
            }
            indexWhile++;
        }
        input.close();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (checkForSpecialChar(matrix[i][j])) {
                    
                } else {

                }
            }
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

    public static boolean checkForSpecialChar(char letter) {
        boolean ret = false;
        char[] notSpecial = "1234567890.".toCharArray();
        switch (letter) {
            case '1':
                break;
            case '2':
                break;
            case '3':
                break;
            case '4':
                break;
            case '5':
                break;
            case '6':
                break;
            case '7':
                break;
            case '8':
                break;
            case '9':
                break;
            case '0':
                break;
            case '.':
                break;
            default:
                break;
        }

        return ret;
    }
    
}