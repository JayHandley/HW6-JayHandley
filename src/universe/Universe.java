package universe;

import model.*;
import java.util.Random;

/**
 * Represents a src.universe with fighters
 */
public class Universe implements Comparable<Universe>, Configurable, Playable {

    private String uid;
    private Duelist d1;
    private Duelist d2;
    private Strategist s1;
    private Strategist s2;
    private Vanguard v1;
    private Vanguard v2;
    private Arena arena;

    /**
     * Creates and runs the src.universe simulation
     */
    public Universe() {
        generateID();
        configureRandom();
        play();
    }

    /**
     * Creates an ID for the src.universe
     * @returns the ID
     */
    public String generateID() {
        Random r = new Random();
        this.uid = "U" + String.valueOf(100000 + r.nextInt(899999));
        return "Universe ID: " + this.uid;
    }

    /**
     * Gets the ID of a src.universe
     * @return the ID
     */
    public String getID() {
        return this.uid; }

     /**
     * Compares two universes to each other
     * @param other the other src.universe
     * @return 0 if the ID is the same, the difference if not
     */
    @Override
    public int compareTo(Universe other) {
        int compareID = this.getID().compareTo(other.getID());
        return compareID;
    }

    /**
     * Creates the random fighters for the src.universe
     */
    @Override
    public void configureRandom() {
        Random r = new Random();

        String[] duelistNames = {"IronMan", "Punisher", "Psylock", "HumanTorch", "Deadpool"};
        String[] strategistNames = {"Jeff", "Loki", "Luna"};
        String[] vanguardNames = {"Magento", "Groot", "DrStrange", "CaptainAmerica"};
        String duelistName = duelistNames[r.nextInt(duelistNames.length)];
        String strategistName = strategistNames[r.nextInt(strategistNames.length)];
        String vanguardName = vanguardNames[r.nextInt(vanguardNames.length)];
        boolean fly = (duelistName.equals("IronMan") || duelistName.equals("HumanTorch"));
        int maxHP = 200 + (r.nextInt(7) * 50);
        int DPS = 30 + (r.nextInt(32) * 10);
        int healing = 50 + (r.nextInt(10) * 10);
        int shieldHealth = 30 + (r.nextInt(7) * 10);
        int percentColor = r.nextInt(40);

        d1 = new Duelist(duelistName, "red", maxHP, fly, DPS);
        d2 = new Duelist(duelistName, "blue", maxHP, fly, DPS);
        s1 = new Strategist(strategistName, "red", maxHP, healing);
        s2 = new Strategist(strategistName, "blue", maxHP, healing);
        v1 = new Vanguard(vanguardName, "red", maxHP, shieldHealth, DPS);
        v2 = new Vanguard(vanguardName, "blue", maxHP, shieldHealth, DPS);
        arena = new Arena(percentColor, percentColor);
    }

    /**
     * Runs the battle simulation for the src.universe
     */
    @Override
    public void play() {
        System.out.println("Playing src.universe " + getID());
        d1.fly();
        d2.fly();
        d2.attack(v1);
        v1.attack(d2);
        s2.heal(d2);
        d1.attack(v2);
        arena.increaseRed(20);
        s1.heal(v1);
        d2.attack(s1);
        arena.increaseBlue(50);
        d1.attack(s2);
        s2.healSelf();
        arena.increaseRed(50);
        v1.attack(v2);
        d2.attack(d1);
        arena.increaseBlue(50);
    }

    /**
     * Compares two universes
     * @param obj the other src.universe
     * @return true if the same, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Universe)) {
            return false;
        }
        return this.hashCode() == obj.hashCode();
    }

    /**
     * Creates a unique number for the Strategist based on its current data
     * @return the unique number
     */
    @Override
    public int hashCode() {
        int res = arena.hashCode();
        res = 31 * res + d1.hashCode();
        res = 31 * res + d2.hashCode();
        res = 31 * res + s1.hashCode();
        res = 31 * res + s2.hashCode();
        res = 31 * res + v1.hashCode();
        res = 31 * res + v2.hashCode();

        return res;
    }
}
