package model;

/**
 * Represents the arena that the battle is fought in
 */
public class Arena {

    private int percentBlue;
    private int percentRed;

    /**
    * To create the arena
    * @param percentBlue the starting progress of the blue team
    * @param percentRed the starting progress of the red team
    */
    public Arena(int percentBlue, int percentRed) {
        this.percentBlue = percentBlue;
        this.percentRed = percentRed;
    }

    /**
    * To increase of progress of team blue
    * @param percent the percent to increase the progress by
    */
    public void increaseBlue(int percent) {
        if (this.percentBlue + percent < 100) {
            this.percentBlue = this.percentBlue + percent;
            System.out.println("Blue is at " + percent + " percent!");
        } else {
            this.percentBlue = 100;
            System.out.println("Blue won the game!");
        }
    }

    /**
    * To increase the progress of team red
    * @param percent the percent to increase the progress by
    */
    public void increaseRed(int percent) {
        if (this.percentRed + percent < 100) {
            this.percentRed = this.percentRed + percent;
            System.out.println("Red is at " + percent + " percent!");
        } else {
            this.percentRed = 100;
            System.out.println("Red won the game!");
        }
    }

    /**
    * Creates a unique number for the arena based on its current data
    * @return the unique number
    */
    public int hashCode() {

        int res = this.percentBlue;
        res = 31 * res + this.percentRed;

        return res;
    }

}