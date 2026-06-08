package registry;

public class CommandParser {

    public static class ParsedCommand {
        public String command;
        public String[] args;

        public ParsedCommand(String command, String[] args) {
            this.command = command;
            this.args = args;
        }
    }

    public ParsedCommand parse(String line) {

        if (line == null || line.trim().isEmpty()) {
            return new ParsedCommand("invalid", new String[0]);
        }

        String[] tokens = line.trim().split("\\s+");

        String command = tokens[0].toLowerCase();

        // could do basic validation here or in the main loop

        String[] args = new String[tokens.length - 1];
        for (int i = 1; i < tokens.length; i++) {
            args[i - 1] = tokens[i];
        }

        return new ParsedCommand(command, args);
    }
}