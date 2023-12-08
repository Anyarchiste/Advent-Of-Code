package day04;

import java.io.File;
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) throws Exception {
        File file = new File(day04.paths.puzzle);
        Scanner input = new Scanner(file);
        int totalPoints = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine();

            line = line.replaceAll("Card [0-9]*: *", "");

            // Index 0 --> Winners
            // Index 1 --> Played
            String[] table = line.split("\u007C");

            String[] winner = table[0].split("\s");
            String[] played = table[1].split("\s");
            int winnerCount = 0;
            String[] winnerList = new String[5];

            for (String string : played) {
                for (int i = 0; i < winner.length; i++) {
                    if (Integer.valueOf(string) == Integer.valueOf(winner[i])) {
                        winnerCount += 1;
                        winnerList[i] = string;
                    }
                }
            }

            if (winnerCount == 0) {
                System.out.println("There was no winning number on this card, sorry");
            } else if (winnerCount == 1) {
                System.out.println("You got one winning number:" + winnerList[0] + " That gives you 1 point");
                totalPoints++;
            } else {
                int intermediatePoints = 0;
                intermediatePoints++;
                for (int i = 1; i < (winnerList.length); i++) {
                    if (i <= 2) {
                        intermediatePoints += 2;
                    } else if (i > 2 && i <= 5) {
                        intermediatePoints += 3;
                    }
                }
                totalPoints += intermediatePoints;
            }
        }
        System.out.println("Puzzle answer: " + totalPoints);
    }
}
