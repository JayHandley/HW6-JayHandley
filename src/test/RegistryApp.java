package test;

import registry.*;

import java.util.Scanner;

public class RegistryApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CommandParser parser = new CommandParser();

        Registry registry = new Registry();

        System.out.println("Universe Registry");
        System.out.println("Commands: ADD, LIST, COPY, SORT, WEAVE, QUIT");

        while (true) {

            System.out.print("> ");

            if (!scanner.hasNextLine()) {
                break;
            }

            String line = scanner.nextLine();

            CommandParser.ParsedCommand cmd = parser.parse(line);

            switch (cmd.command) {

                case "add":
                    registry.addFromArgs(scanner, cmd.args);
                    break;

                case "list":
                    registry.printAll();
                    break;

                case "copy":
                    if (cmd.args.length < 2) {
                        System.out.println("Usage: COPY <oldId> <newId>");
                        break;
                    }
                    registry.cloneCharacter(cmd.args[0], cmd.args[1]);
                    break;

                case "sort":
                    if (cmd.args.length < 1) {
                        System.out.println("Usage: SORT <id|name|stat>");
                        break;
                    }
                    registry.sort(cmd.args[0]);
                    break;

                case "weave":
                    registry.weave();
                    break;


                case "quit":
                    System.out.println("Goodbye.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }

        scanner.close();
    }
}