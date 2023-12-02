package day01;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import day01.paths;

/**
 * Challenge-1
 */
public class Challenge {

    public static void main(String[] args) throws Exception {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] line = new char[0];
        int solution = 0;

        // pass the path to the file as a parameter
        File file = new File(paths.day01_input_1);
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            line = input.nextLine().toCharArray();
            String onlyInt = "";
            char[] line2 = stringToInt(line);
            for (int i = 0; i < line2.length; i++) {
                if (!checkIfInArray(line2[i], alphabet)) {
                    onlyInt += line2[i];
                }
            }
            char[] array = onlyInt.toCharArray();
            String sol = "" + array[0] + array[array.length - 1];
            solution += Integer.valueOf(sol);
        }

        System.out.println(solution);
        input.close();
    }

    public static boolean checkIfInArray(char toSearch, char[] alphabet) {
        boolean isInArray = false;
        for (char c : alphabet) {
            if (c == toSearch) {
                isInArray = true;
            }
        }
        return isInArray;
    }

    public static char[] stringToInt(char[] line) {
        String r = String.valueOf(line);
        String[] numbers = new String[]{"eight","two","one","three","four","five","six","seven","nine"};
        String[] numerals = new String[]{"e8t","t2o","o1e","t3e","f4r","f5e","s6x","s7n","n9e"};
        for (int i = 0; i < numbers.length; i++) {
            r = r.replace(numbers[i], numerals[i]);
        }

        return r.toCharArray();
    }
}