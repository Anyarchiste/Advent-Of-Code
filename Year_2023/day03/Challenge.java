package day03;

import day03.paths;
import java.io.File;
import java.util.Scanner;

/**
 * Challenge
 */
public class Challenge {

    public static boolean UP = false;
    public static boolean DOWN = false;

    public static void main(String[] args) throws Exception {
        int answer = 0;
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
                    try {
                        answer += Integer.valueOf(checkNombreAvant(matrix, i, j));
                    } catch (Exception e) {
                        answer += 0;
                    }
                    try {
                        answer += Integer.valueOf(checkNombreApres(matrix, i, j));
                    } catch (Exception e) {
                        answer += 0;
                    }
                    try {
                        answer += Integer.valueOf(checkNombreDessus(matrix, i, j));
                    } catch (Exception e) {
                        answer += 0;
                    }
                    try {
                        answer += Integer.valueOf(checkNombreDessous(matrix, i, j));
                    } catch (Exception e) {
                        answer += 0;
                    }
                    if (UP) {
                        try {
                            answer += Integer.valueOf(checkNombreDiagoArriereUp(matrix, i, j));
                        } catch (Exception e) {
                            answer += 0;
                        }
                        try {
                            answer += Integer.valueOf(checkNombreDiagoAvantUp(matrix, i, j));
                        } catch (Exception e) {
                            answer += 0;
                        }
                    }
                    if (DOWN) {
                        try {
                            answer += Integer.valueOf(checkNombreDiagoArriereDown(matrix, i, j));
                        } catch (Exception e) {
                            answer += 0;
                        }
                        try {
                            answer += Integer.valueOf(checkNombreDiagoAvantDown(matrix, i, j));
                        } catch (Exception e) {
                            answer += 0;
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        System.out.println(answer);


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
                ret = true;
                break;
        }

        return ret;
    }

    public static String checkNombreAvant(char[][] matrix, int i, int j) {
        String toAdd = "";
        if (String.valueOf(matrix[i][j - 1]).equals("[0-9]")) {
            if (String.valueOf(matrix[i][j - 3]).equals("[0-9]")) {
                toAdd += String.valueOf(matrix[i][j - 3]);
                }
            if (String.valueOf(matrix[i][j - 2]).equals("[0-9]")) {
                toAdd += String.valueOf(matrix[i][j - 2]);
                }
            toAdd += String.valueOf(matrix[i][j - 1]);
        }
        System.out.println(toAdd);
        return toAdd;
        
    }

    public static String checkNombreApres(char[][] matrix, int i, int j) {
        String toAdd = "";
        if (String.valueOf(matrix[i][j + 1]).equals("[0-9]")) {
            if (String.valueOf(matrix[i][j + 1]).equals("[0-9]")) {
                toAdd += String.valueOf(matrix[i][j + 1]);
                }
            if (String.valueOf(matrix[i][j + 2]).equals("[0-9]")) {
                toAdd += String.valueOf(matrix[i][j + 2]);
                }
            
            toAdd += String.valueOf(matrix[i][j + 3]);
        }
        
        return toAdd;
    }

    public static String checkNombreDessus(char[][] matrix, int i, int j) {
        String toAdd = "";
        if (String.valueOf(matrix[i - 1][j]).equals("[0-9]")) {
            if (String.valueOf(matrix[i - 1][j - 1]).equals("[0-9]")) {
                if (String.valueOf(matrix[i - 1][j - 2]).equals("[0-9]")) {
                    toAdd += String.valueOf(matrix[i - 1][j - 2] + String.valueOf(matrix[i - 1][j - 1]) + String.valueOf(matrix[i - 1][j]));
                } else if (String.valueOf(matrix[i - 1][j + 1]).equals("[0-9]")) {
                    toAdd += String.valueOf(matrix[i - 1][j - 1]) + String.valueOf(matrix[i - 1][j]) + String.valueOf(matrix[i - 1][j + 1]);
                } else {
                    toAdd += String.valueOf(matrix[i - 1][j - 1] + String.valueOf(matrix[i - 1][j]));
                }
            } else if (String.valueOf(matrix[i - 1][j + 1]).equals("[0-9]")) {
                if (String.valueOf(matrix[i - 1][j + 2]).equals("[0-9]")) {
                    toAdd += String.valueOf(matrix[i - 1][j]) + String.valueOf(matrix[i - 1][j + 1]) + String.valueOf(matrix[i - 1][j + 2]);
                } else {
                    toAdd += String.valueOf(matrix[i - 1][j]) + String.valueOf(matrix[i - 1][j + 1]);
                }
            } else {
                toAdd += String.valueOf(matrix[i - 1][j]);
            }
        } else {
            UP = true;
        }

        return toAdd;
    }

    public static String checkNombreDessous(char[][] matrix, int i, int j) {
        String toAdd = "";
        if (String.valueOf(matrix[i + 1][j]).equals("[0-9]")) {
            if (String.valueOf(matrix[i + 1][j - 1]).equals("[0-9]")) {
                if (String.valueOf(matrix[i + 1][j - 2]).equals("[0-9]")) {
                    toAdd += String.valueOf(matrix[i + 1][j - 2] + String.valueOf(matrix[i + 1][j - 1]) + String.valueOf(matrix[i + 1][j]));
                } else if (String.valueOf(matrix[i + 1][j + 1]).equals("[0-9]")) {
                    toAdd += String.valueOf(matrix[i + 1][j - 1]) + String.valueOf(matrix[i + 1][j]) + String.valueOf(matrix[i + 1][j + 1]);
                } else {
                    toAdd += String.valueOf(matrix[i + 1][j - 1] + String.valueOf(matrix[i + 1][j]));
                }
            } else if (String.valueOf(matrix[i + 1][j + 1]).equals("[0-9]")) {
                if (String.valueOf(matrix[i + 1][j + 2]).equals("[0-9]")) {
                    toAdd += String.valueOf(matrix[i + 1][j]) + String.valueOf(matrix[i + 1][j + 1]) + String.valueOf(matrix[i + 1][j + 2]);
                } else {
                    toAdd += String.valueOf(matrix[i + 1][j]) + String.valueOf(matrix[i + 1][j + 1]);
                }
            } else {
                toAdd += String.valueOf(matrix[i + 1][j]);
            }
        } else {
            DOWN = true;
        }

        return toAdd;
    }

    public static String checkNombreDiagoArriereUp(char[][] matrix, int i, int j) {
        String toAdd = "";
        String unite = String.valueOf(matrix[i - 1][j - 1]);
        String dixaine = String.valueOf(matrix[i - 1][j - 2]);
        String centaine = String.valueOf(matrix[i - 1][j - 3]);

        if (unite.equals("[0-9]")) {
            if (dixaine.equals("[0-9]")) {
                if (centaine.equals("[0-9]")) {
                   toAdd += centaine + dixaine + unite; 
                } else {
                    toAdd += dixaine + unite;
                }
            }
            toAdd += unite;
            
        }

        return toAdd;
    }
    
    public static String checkNombreDiagoAvantUp(char[][] matrix, int i, int j) {
        String toAdd = "";
        String unite = String.valueOf(matrix[i - 1][j + 3]);
        String dixaine = String.valueOf(matrix[i - 1][j + 2]);
        String centaine = String.valueOf(matrix[i - 1][j + 1]);

        if (centaine.equals("[0-9]")) {
            if (dixaine.equals("[0-9]")) {
                if (unite.equals("[0-9]")) {
                   toAdd += centaine + dixaine; 
                } else {
                    toAdd += dixaine;
                }
            }
            toAdd += unite;
        }

        return toAdd;
    }

    public static String checkNombreDiagoArriereDown(char[][] matrix, int i, int j) {
        String toAdd = "";
        String unite = String.valueOf(matrix[i + 1][j - 1]);
        String dixaine = String.valueOf(matrix[i + 1][j - 2]);
        String centaine = String.valueOf(matrix[i + 1][j - 3]);

        if (unite.equals("[0-9]")) {
            if (dixaine.equals("[0-9]")) {
                if (centaine.equals("[0-9]")) {
                   toAdd += centaine + dixaine; 
                } else {
                    toAdd += dixaine;
                }
            }
            toAdd += unite;
        }

        return toAdd;
    }

    public static String checkNombreDiagoAvantDown(char[][] matrix, int i, int j) {
        String toAdd = "";
        String unite = String.valueOf(matrix[i + 1][j + 3]);
        String dixaine = String.valueOf(matrix[i + 1][j + 2]);
        String centaine = String.valueOf(matrix[i + 1][j + 1]);

        if (centaine.equals("[0-9]")) {
            if (dixaine.equals("[0-9]")) {
                if (unite.equals("[0-9]")) {
                   toAdd += centaine + dixaine; 
                } else {
                    toAdd += dixaine;
                }
            }
            toAdd += unite;
        }

        return toAdd;
    }
}