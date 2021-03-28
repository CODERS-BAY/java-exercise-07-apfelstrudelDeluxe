import java.util.Random;
import java.util.Scanner;

public class GameOfLife2 {

    // Spielfeld in 2D Array mit globalen Werten
    private static final int HEIGHT = 8;
    private static final int WIDTH = 4;
    private static final String[][] gameField = new String[HEIGHT][WIDTH];  // HEIGH, WIDTH sind nur Platzhalter, bestimmen Größe des Arrays

    // Spielfeld ausgeben
    private static  void printField() {
        for (String [] array : gameField) {
            System.out.print(" | ");
            for (String s : array) {
                System.out.print(s + " ");
            }
            System.out.println("|");
            System.out.println();
        }
    }

    // Positionen zu checken am Spielfeld, im Kreis rund um meine Position
    private static final int [][] NEIGHBOURS = {
            {0, -1},
            {-1, -1},
            {+1, -1},
            {0, +1},
            {-1, +1},
            {+1, +1},
            {-1, 0},
            };

    // Feld mit lebenden und toten Zellen befüllen, manuell auch möglich
    private static void initializeField() {
        for( int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++){
                // coin flip
                int alive = new Random().nextInt(2);   // nur 2 Werte: 0 und 1
                if (alive == 0) {
                    gameField[i][j] = ".";
                } else {
                    gameField[i][j] = "*";
                }
            }
        }
    }


    // Prüfen, ob etwas lebt oder nicht
    public static boolean isAlive(int x, int y) {
        if (x < HEIGHT && y < WIDTH         // Obergrenze festlegen
            && x >= 0 && y >= 0) {          // Untergrenze festlegen
            return gameField[x][y].equals("*");
        }
        return false;
    }

    // Prüfen aller Koordinaten rund um einen lebenden Wert
    private static int countNeighbours (int x, int y) {
        int count = 0;
        for (int [] offset : NEIGHBOURS) { // Ich gehe durch die Koordinaten durch
            if (isAlive(x + offset[0], y + offset[1])) {  // Ich prüfe rnd um den lebendigen Wert alle 8 Koordinaten.
                // isAlive hat koordinaten
                // zu dieser Koodinate zähle ich neighbours dazu
                // 0. Position des offset-Array + x-Koordinate, greife darauf zu mit isAlive und zähle Koordinaten zum Ausgangspunkt dazu
                // 1. Position des offset-Ayyay + y-Koordinate
                // Ich überschreibe an der x.
                count++;
            }
        }
        return count;
    }


    // Spielregeln
    private static void play(int rounds) {
        int round = 0;
        while (round <= rounds) {
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField[i].length; j++) {
                    int neighbours = countNeighbours(i, j);

                    //firste rule
                    if (neighbours == 3) {
                        gameField[i][j] = "*";
                    }

                    // second rule
                    if (neighbours < 2) {
                        gameField[i][j] = ".";
                    }

                    // third rule
                    if (neighbours == 2) {
                        gameField[i][j] = "*";
                    }

                    // fourth rule
                    if (neighbours > 3) {
                        gameField[i][j] = ".";
                    }



                }
            }
            round++;
        }
    }


    public static void main(String[] args) {
        System.out.println("Wieviele Runden willst du spielen?");
        Scanner scanner = new Scanner(System.in);
        int rounds = scanner.nextInt();

        initializeField();
        printField();
        play(rounds);
        System.out.println("==============================");
        printField();
    }

}
