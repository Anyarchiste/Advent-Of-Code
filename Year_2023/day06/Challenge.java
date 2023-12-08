package day06;

import java.io.File;
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) throws Exception {
        File file = new File(day06.paths.puzzle);
        Scanner input = new Scanner(file);

        String[] puzzle = new String[2];

        while (input.hasNextLine()) {
            String line = input.nextLine();

            for (int i = 0; i < puzzle.length; i++) {
                puzzle[i] = line;
            } 
        }
        input.close();

        // Index 0 --> Time
        // Index 1 --> Distance
        String[] cleanLines = getCleanLines(puzzle);
    }

    public static String[] getCleanLines(String[] puzzle) {
        String[] clean = new String[puzzle.length];

        for (int i = 0; i < clean.length; i++) {
            clean[i] = puzzle[i].replaceAll("Time: *", "");
            clean[i] = puzzle[i].replaceAll("Distance: *", "");
        }

        return clean;
    }
}
