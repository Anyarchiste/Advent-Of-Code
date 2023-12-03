package day02;

import java.io.File;
import java.util.Scanner;
// import day02.paths;
import java.util.regex.Pattern;

public class Challenge {
    // 12 red cubes, 13 green cubes, and 14 blue cubes
    public static final int RED = 12;
    public static final int GREEN = 13;
    public static final int BLUE = 14;

    public static void main(String[] args) throws Exception {
        // pass the path to the file as a parameter
        File file = new File(paths.input);
        Scanner puzzle = new Scanner(file);
        int solution = 0;
        int gameNumber = 0;
        int solutionPart2 = 0;

        while (puzzle.hasNextLine()) {
            gameNumber += 1;
            String line = puzzle.nextLine();

            line = line.replaceAll("Game [\\d]*: ", "");
            String[] splitted = line.split("; ");
            // for (String string : splitted) {
            // System.out.println(string);
            // }
            // System.out.println();

            boolean[] areAllDrawsPossible = new boolean[splitted.length];
            int redPart2 = 1;
            int bluePart2 = 1;
            int greenPart2 = 1;
            for (int i = 0; i < splitted.length; i++) {
                int nbrOfRed = 0;
                int nbrOfBlue = 0;
                int nbrOfGreen = 0;

                // System.out.println(splitted[i]);
                String[] diffColours = splitted[i].split(", ");
                for (int j = 0; j < diffColours.length; j++) {
                    if (diffColours[j].contains("blue")) {
                        nbrOfBlue = Integer.valueOf(diffColours[j].replace(" blue", ""));
                        if (nbrOfBlue > bluePart2) {
                            bluePart2 = nbrOfBlue;
                        }

                    } else if (diffColours[j].contains("red")) {
                        nbrOfRed = Integer.valueOf(diffColours[j].replace(" red", ""));
                        if (nbrOfRed > redPart2) {
                            redPart2 = nbrOfRed;
                        }

                    } else if (diffColours[j].contains("green")) {
                        nbrOfGreen = Integer.valueOf(diffColours[j].replace(" green", ""));
                        if (nbrOfGreen > greenPart2) {
                            greenPart2 = nbrOfGreen;
                        }
                    }

                }

                if (nbrOfBlue <= BLUE && nbrOfGreen <= GREEN && nbrOfRed <= RED) {
                    areAllDrawsPossible[i] = true;
                    continue;
                }
            }
            if (areAllTrue(areAllDrawsPossible)) {
                solution += gameNumber;
            }

            solutionPart2 += greenPart2 * redPart2 * bluePart2;
        }
        puzzle.close();
        System.out.println("La solution de la partie 1 est: " + solution);
        System.out.println("La solution de la partie 2 est: " + solutionPart2);
    }

    public static boolean areAllTrue(boolean[] array) {
        for (boolean b : array)
            if (!b)
                return false;
        return true;
    }

}