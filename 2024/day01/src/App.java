import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import secrets.secrets;

public class App {

    private static Boolean PART_ONE = false;
    private static ArrayList<Integer> listA = new ArrayList<>();
    private static ArrayList<Integer> listB = new ArrayList<>();
    private static HashMap<Integer, Integer> setB = new HashMap<>();
    private static Integer answerToRiddle = 0;

    public static void main(String[] args) throws Exception {
        File file = new File(secrets.INPUT);

        // Creating an object of BufferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        String[] numbers;
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) {

            numbers = st.split("   ");

            listA.add(Integer.valueOf(numbers[0]));
            listB.add(Integer.valueOf(numbers[1]));

        }
        br.close();

        listA.sort(null);
        listB.sort(null);

        if (PART_ONE) {

            for (int i = 0; i < listA.size(); i++) {

                int difference = listA.get(i) - listB.get(i);

                if (difference < 0) {
                    difference = difference * -1;
                }

                answerToRiddle += difference;

            }
        } else {

            for (Integer multiplier : listB) {
                
                if (setB.containsKey(multiplier)) {
                    setB.put(multiplier, setB.get(multiplier) + 1);
                } else {
                    setB.put(multiplier, 1);
                }

            }

            for (Integer location : listA) {
                
                answerToRiddle += location * (setB.get(location) == null ? 0 : setB.get(location) );

            }

        }

        System.out.println(answerToRiddle);

    }
}
