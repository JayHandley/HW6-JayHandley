package registry;

import list.*;

import java.util.Scanner;

public class Registry {

    /**
     * Creates a Registry
     */
    public Registry() {
        LinkedList<Hero> heroRegistery = new LinkedList<>();

    }

    /**
     * Adds a hero to the registry
     * @param scanner the scanner to get the wanted info to add
     * @param args i don't know what args are
     */
    public void addFromArgs(Scanner scanner, String[] args) {
        System.out.print("Enter Hero Name: ");
        String name = scanner.nextString();
        System.out.println();

        System.out.print("Enter Hero Team Color: ");
        String color = scanner.nextString();
        System.out.println();

        System.out.print("Enter Hero HP: ");
        String maxHP = scanner.nextInt();
        System.out.println();

        Hero h = new Hero(name, color, maxHP);
        heroRegistry.add(h);
        System.out.println("Hero added");
    }

    /**
     * Prints the hero registry
     */
    public void printAll() {
        for(int i = 0; i < heroRegistry.size; i++) {
            System.out.println("Name: " + heroRegistry.get(i).getName() + "Team: " + heroRegistry.get(i).getTeam() + "HP: " + heroRegistry.get(i).getMaxHealth());
    }

    /**
     * Clones a character from the hero registry
     * @param name the name of the character to clone
     * @param dunnoWtfIsThisIDontKnowArgsLeaveMeAlone why are there two of these
     */
    public void cloneCharacter(String name, String dunnoWtfIsThisIDontKnowArgsLeaveMeAlone) {
        Boolean found = false;
        for(int i = 0; i < heroRegistry.size; i++) {
            hero h1 = heroRegistry.get(i);
            if(h1.name.equals(name)) {
                h2 = h1.copy();
                heroRegistry.add(h2);
                System.out.println("Hero copied");
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("Hero not in registry");
        }
    }

    /**
     * Sorts the registry
     * @param args the compartor to sort the list
     */
    public void sort(String args) {
        heroRegistry.sort(args);
        System.out.println("Registry sorted");
    }

    /**
     * Weaves the registry
     */
    public void weave() {
        heroRegistry.weave();
        System.out.println("Registry weaved");
    }


}