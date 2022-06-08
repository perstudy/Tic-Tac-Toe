import java.util.Scanner;

public class Main {
    static String[][] str = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    static int winX;
    static int winO;
    static int players;
    static boolean main;
    static boolean b;
    static boolean b1;
    static boolean tryCatchBool;
    static String playersVol;

    public static void main(String[] args) {
        System.out.println("---------");
        for (String[] strings : str) {
            System.out.print("| ");
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        Scanner sc = new Scanner(System.in);
        String input1;
        int charToInt1;
        int charToInt2;
        while (!main) {
            if (players % 2 == 0) {
                playersVol = "X";
            } else {
                playersVol = "O";
            }
            input1 = sc.nextLine().replaceAll("\\s", "");
            charToInt1 = Character.getNumericValue(input1.charAt(0));
            charToInt2 = Character.getNumericValue(input1.charAt(1));
            try {
                int tryCatch = Integer.parseInt(input1);
                tryCatchBool = true;
            } catch (NumberFormatException e) {
                tryCatchBool = false;
            }
            if (!tryCatchBool) {
                System.out.println("You should enter numbers!");
                continue;
            }
            while (!b) {
                if (charToInt1 > 3 || charToInt2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    input1 = sc.nextLine().replaceAll("\\s", "");
                    charToInt1 = Character.getNumericValue(input1.charAt(0));
                    charToInt2 = Character.getNumericValue(input1.charAt(1));
                    continue;
                }
                while (!b1) {
                    if (str[charToInt1 - 1][charToInt2 - 1].equals(" ")) {
                        str[charToInt1 - 1][charToInt2 - 1] = playersVol;
                        b1 = true;
                        b = true;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        input1 = sc.nextLine().replaceAll("\\s", "");
                        charToInt1 = Character.getNumericValue(input1.charAt(0));
                        charToInt2 = Character.getNumericValue(input1.charAt(1));
                        break;
                    }
                }
            }
            System.out.println("---------");
            for (String[] strings : str) {
                System.out.print("| ");
                for (String string : strings) {
                    System.out.print(string + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");
            for (int i = 0; i < str.length; i++) {
                for (int j = 0; j < 1; j++) {
                    if (str[i][j] == "X" && str[i][j + 1] == "X" && str[i][j + 2] == "X") {
                        winX++;
                        break;
                    } else if (str[j][i] == "X" && str[j + 1][i] == "X" && str[j + 2][i] == "X") {
                        winX++;
                        break;
                    }
                }
                if (winX > 0) break;
            }
            for (int i = 0; i < 1; i++) {
                if (str[i][i] == "X" && str[i + 1][i + 1] == "X" && str[i + 2][i + 2] == "X") {
                    winX++;
                } else if (str[i][i + 2] == "X" && str[i + 1][i + 1] == "X" && str[i + 2][i] == "X") {
                    winX++;
                }
            }
            for (int i = 0; i < str.length; i++) {
                for (int j = 0; j < 1; j++) {
                    if (str[i][j] == "O" && str[i][j + 1] == "O" && str[i][j + 2] == "O") {
                        winO++;
                        break;
                    } else if (str[j][i] == "O" && str[j + 1][i] == "O" && str[j + 2][i] == "O") {
                        winO++;
                        break;
                    }
                }
                if (winO > 0) break;
            }
            for (int i = 0; i < 1; i++) {
                if (str[i][i] == "O" && str[i + 1][i + 1] == "O" && str[i + 2][i + 2] == "O") {
                    winO++;
                } else if (str[i][i + 2] == "O" && str[i + 1][i + 1] == "O" && str[i + 2][i] == "O") {
                    winO++;
                }
            }
            b = b1 = false;
            players++;
            if (winO > 0) {
                System.out.println("O wins");
                main = true;
            } else if (winX > 0) {
                System.out.println("X wins");
                main = true;
            }
        }
        sc.close();
    }
}