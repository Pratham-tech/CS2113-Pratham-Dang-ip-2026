package duke;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Pratbot.\nWhat can I do for you?");
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("bye")) {
            if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + "." + tasks.get(i));
                }
            } else if (input.startsWith("mark ")) {
                int taskNumber = Integer.parseInt(input.substring(5));
                Task t = tasks.get(taskNumber - 1);
                t.markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + t);
            } else if (input.startsWith("unmark ")) {
                int taskNumber = Integer.parseInt(input.substring(7));
                Task t = tasks.get(taskNumber - 1);
                t.unmarkAsDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + t);
            } else if (input.startsWith("todo ")) {
                String description = input.substring(5);
                Task t = new Todo(description);
                tasks.add(t);
                printAddedTask(t, tasks.size());
            } else if (input.startsWith("deadline ")) {
                String remainder = input.substring(9);
                String[] parts = remainder.split(" /by ", 2);
                Task t = new Deadline(parts[0], parts[1]);
                tasks.add(t);
                printAddedTask(t, tasks.size());
            } else if (input.startsWith("event ")) {
                String remainder = input.substring(6);
                String[] fromSplit = remainder.split(" /from ", 2);
                String[] toSplit = fromSplit[1].split(" /to ", 2);
                Task t = new Event(fromSplit[0], toSplit[0], toSplit[1]);
                tasks.add(t);
                printAddedTask(t, tasks.size());
            } else {
                Task t = new Todo(input);
                tasks.add(t);
                printAddedTask(t, tasks.size());
            }
            input = sc.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static void printAddedTask(Task t, int totalTasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
    }
}