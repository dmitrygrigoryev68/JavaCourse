package Patterns;

import java.util.*;

public class Patterns {

    public static void main(String[] args) {

        SuperSpiel superSpiel = new SuperSpiel();
        MittelSpiel mittelSpiel = new MittelSpiel();
        SchwachSpiel schwachSpiel = new SchwachSpiel();

        Map<Integer,String> broker = new HashMap<>();

        Scanner in = new Scanner(System.in);

        broker.put(1,getCurrentGame(superSpiel));
        broker.put(2,getCurrentGame(mittelSpiel));
        broker.put(3,getCurrentGame(schwachSpiel));

        System.out.println("\nLADIES AND GENTELMEN!!!");
        System.out.println("WELCOME TO OUR SPIELHALLE!!!");
        System.out.println("You can choice between three our games:");
        System.out.println("SuperSpiel  - type " + 1);
        System.out.println("MittelSpiel - type " + 2);
        System.out.println("ScwachSpiel - type " + 3 + "\n");
        System.out.println("Input a number of game, please: ");

        int num = in.nextInt();

        System.out.println(broker.get(num));

    }

    static String getCurrentGame(Games game) {
        return  "We are playing " + game.letsPlay();
    }
}
