package duke;

/**
 * Represents an error specific to Duke, such as invalid or incomplete user commands.
 */
public class DukeExceptions extends Exception {
    public DukeExceptions(String message) {
        super(message);
    }
}