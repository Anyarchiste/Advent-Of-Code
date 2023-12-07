package day04;

import java.io.File;
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) throws Exception {
        File file = new File(day04.paths.puzzle);
        Scanner input = new Scanner(file);
        int totalWinner = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine();

            line = line.replaceAll("Card [0-9]*: *", "");

            // Index 0 --> Winners
            // Index 1 --> Played
            String[] table = line.split("|");

            String[] winner = table[0].split(" ");
            String[] played = table[1].split(" ");
            int winnerCount = 0;
            String[] winnerList = new String[5];

            for (String string : played) {
                for (int i = 0; i < winner.length; i++) {
                    if (string == winner[i]) {
                        winnerCount++;
                        totalWinner++;
                        winnerList[i] = string;
                    }
                }
            }

            if (winnerCount == 0) {
                System.out.println("There was no winning number on this card, sorry");
            } if (winnerCount == 1) {
                System.out.println("You got one winning number:" + winnerList[0] + " That gives you 1 point");
            } else {
                int intermediatePoints = 0;
                
            }

        }
    }
}
