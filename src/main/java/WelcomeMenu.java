public class WelcomeMenu extends JavaFXTemplate {
    private static String rules;
    private int odds;

    public static String getRules() {
        rules = " Players wager by choosing a set amount of numbers( pick 2 numbers, pick 10 numbers, etc.) ranging from 1 to 80. " +
                "After all players have made their wagers and picked their numbers, " +
                "twenty numbers are drawn at random, between 1 and 80 with no duplicates. " +
                "Players win by matching a set amount of their numbers to the numbers that are randomly drawn.";
        return rules;
    }
    // inputs user spots, outputs the odds selection into setOdds, getOdds used for game logic
    public void placeOdds(int numSpots) {
        if (numSpots != 1 && numSpots != 4 && numSpots != 8 && numSpots != 10) {
            System.out.println("Invalid number of spots");
        }

        if (numSpots == 1) {
            setOdds(1);//"25% chance of winning";// need to be integer values that affect game outcome
        } else if (numSpots == 4) {
        	setOdds(2); //= "25.90% chance of winning";// need to be integer values that affect game outcome
        } else if (numSpots == 8) {
            setOdds(3); //= "10.23% chance of winning";// need to be integer values that affect game outcome
        } else if (numSpots == 10) {
            setOdds(4); //= "11.04% chance of winning"; // need to be integer values that affect game outcome
        }
        else {
        	// set text box to let user know input invalid
        }
    }


    public void quitKeno() {
        System.exit(0);
    }

	public int getOdds() {
		return this.odds;
	}

	public void setOdds(int odds) {
		this.odds = odds;
	}



}
