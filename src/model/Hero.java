package model;

import datastore.*;
import registry.Copyable;

/**
 * Represents a hero
 */
public abstract class Hero<T> implements CSVStorable, Copyable<T> {

    final String name;
    final String team;
    final int maxHP;
    public int currentHP;

    /**
    * Creates a fighter
    * @param name the name of the fighter
    * @param team the team of the fighter
    * @param maxHP the maximum health of the fighter
    */
    public Hero(String name, String team, int maxHP) {
        this.name = name;
        this.team = team;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    /**
    * Gets the name of a fighter
    * @return the name
    */
    public String getName() {
        return this.name;
    }

    /**
    * Gets the team color of a fighter
    * @return the team color
    */
    public String getTeam() {
        return this.team;
    }

    /**
    * Gets the maximum health of a fighter
    * @return the maximum health
    */
    public int getMaxHealth() {
        return this.maxHP;
    }

    /**
    * Gets the current health of a fighter
    * @return the current health
    */
    public int getCurrentLife() {
        return (this.currentHP);
    }

    /**
    * Causes the fighter to take damage when attacked
    */
    void takeDamage(int damage) {
        System.out.println("Took " + damage + " damage.");
    }

    /**
     *
     */
    @Override
    public T copy() {
        element T = new Hero(this.getName(), this.getTeam(), this.getMaxHealth());
        return (T);
    }
}