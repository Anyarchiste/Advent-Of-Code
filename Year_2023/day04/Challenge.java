package day04;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) throws Exception {
        File file = new File(day04.paths.puzzle);
        Scanner input = new Scanner(file);
        int totalPoints = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine();

            line = line.replaceAll("Card *[0-9]*: *", "");

            // Index 0 --> Winners
            // Index 1 --> Played
            String[] table = line.split(" \\| ");

            String[] winner = getRidOfFuckingSpaces(table[0].split("\s"));
            String[] played = getRidOfFuckingSpaces(table[1].split("\s"));

            int winnerCount = 0;
            String[] winnerList = new String[5000];
            for (String string : played) {
                for (int i = 0; i < winner.length; i++) {
                    if (string == "") {
                        break;
                    } else if (Integer.valueOf(string) == Integer.valueOf(winner[i])) {
                        winnerList[winnerCount] = string;
                        winnerCount += 1;
                    }
                }

            }
            totalPoints += countPoints(winnerCount);
        }
        System.out.println("Puzzle answer: " + totalPoints);
        input.close();
    }

    public static int countPoints(int x) {
        if (x == 0) {
            return 0;
        } else {
            // 1 << N is 2^N
            return 1 << (x - 1);
        }
    }

    public static String[] getRidOfFuckingSpaces(String[] args) {
    String[] firstArray = args;

    List<String> list = new ArrayList<String>();

    for(String s : firstArray) {
       if(s != null && s.length() > 0) {
          list.add(s);
       }
    }

    firstArray = list.toArray(new String[list.size()]);

    return firstArray;
    }
}
