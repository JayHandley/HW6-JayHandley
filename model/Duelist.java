package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
* Represents a Duelist class fighter
*/
public class Duelist extends Hero {

    final boolean fly;
    final int DPS;
    public int flyHash = 0;

    /**
    * Creates a Duelist fighter
    * @param name the name of the fighter
    * @param team the team of the fighter
    * @param maxHP the maximum health of the fighter
    * @param fly whether the fighter can fly or not
    * @param DPS the amount of damage the fighter does
    */
    public Duelist(String name, String team, int maxHP, boolean fly, int DPS) {
        super(name, team, maxHP);
        this.currentHP = maxHP;
        this.fly = fly;
        this.DPS = DPS;
    }

    /**
    * Starts flying if the fighter can
    */
    public void fly() {
        if(this.fly) {
            System.out.println(getName() + " is flying.");
        }
    }

    /**
    * Attacks another fighter
    * @param target the fighter being attacked
    */
    public void attack(Hero target) {
        System.out.println(getName() + " attacked " + target);
        target.takeDamage(this.DPS);
    }

    /**
    * Overrides damage from another fighter
    * @param damage the damage being dealt
    */
    @Override void takeDamage(int damage) {
        if(this.fly) {
            damage = damage / 2;
            System.out.println(getName() + " avoided some of the attack!");
        }
        if(this.currentHP <= damage) {
            System.out.println(getName() + " died.");
            this.currentHP = getMaxHealth();
        } else {
            System.out.println(getName() + " took " + damage + " damage.");
            this.currentHP = (this.currentHP - damage);
        }
    }

    /**
    * Creates a string describe the fighter
    * @return the string created
    */
    @Override
    public String toString() {
        return (getName() + " is a dangerous Hero that deals a lot of damage.");
    }

    /**
    * Checks if two Duelists are the same
    * @param obj the object to be compared to
    * @return true if they are the same, false if not
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            System.out.println("obj is null");
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            System.out.println("wrong type");
            return false;
        }
        if (!(obj instanceof Duelist)) {
            System.out.println("wrong type");
            return false;
        }

        Duelist other = (Duelist) obj;

        if (!(this.getName().equals(other.getName()))) {
            System.out.println("name is different");
            return false;
        }
        if (!(this.getMaxHealth() == other.getMaxHealth())) {
            System.out.println("max health is different");
            return false;
        }
        if (this.fly == other.fly) {
            System.out.println("flight ability is different");
            return false;
        }
        if (this.DPS == other.DPS) {
            System.out.println("damage stat is different");
            return false;
        }
        return true;
    }

    /**
    * Creates a unique number for the Duelist based on its current data
    * @return the unique number
    */
    @Override
    public int hashCode() {
        if(this.fly) {
            flyHash = 10;
        } else {
            flyHash = 5;
        }

        int res = getName().hashCode();
        res = 31 * res + getMaxHealth();
        res = 31 * res + (flyHash);
        res = 31 * res + this.DPS;

        return res;
    }

    /**
    * Creates the "Duelist.CSV" file if it doesn't exist and then writes the information of the Duelist to the next line
    */
    @Override
    public void toCsv() {
        File openFile = new File("Duelist.CSV");

        if(!(openFile.length() == 0)) {
            try (FileWriter writer = new FileWriter(openFile)) {
                writer.write("Name, Team, Max Health, Flight, DPS");
                writer.close();
            } catch (IOException e) {
                System.out.println("An error occurred writing the file.");
            }
        }
        try (FileWriter addWriter = new FileWriter(openFile)) {
            addWriter.write((getName() + ", " + getTeam() + ", " + getMaxHealth() + ", " + this.fly + ", " + this.DPS));
            addWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred writing the file.");
        }
    }

}