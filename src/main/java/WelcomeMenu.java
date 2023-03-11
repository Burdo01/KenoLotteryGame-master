public class WelcomeMenu extends JavaFXTemplate {
    private static String rules;
    private String odds;

    public static String getRules() {
        rules = " Players wager by choosing a set amount of numbers( pick 2 numbers, pick 10 numbers, etc.) ranging from 1 to 80. " +
                "After all players have made their wagers and picked their numbers, " +
                "twenty numbers are drawn at random, between 1 and 80 with no duplicates. " +
                "Players win by matching a set amount of their numbers to the numbers that are randomly drawn.";
        return rules;
    }

    public String getOdds(int numSpots) {
        if (numSpots != 1 && numSpots != 4 && numSpots != 8 && numSpots != 10) {
            System.out.println("Invalid number of spots");
        }

        if (numSpots == 1) {
            this.odds = "25% chance of winning";
        } else if (numSpots == 4) {
            this.odds = "25.90% chance of winning";
        } else if (numSpots == 8) {
            this.odds = "10.23% chance of winning";
        } else if (numSpots == 10) {
            this.odds = "11.04% chance of winning";
        }
        return odds;
    }


    public void quitKeno() {
        System.exit(0);
    }



}
