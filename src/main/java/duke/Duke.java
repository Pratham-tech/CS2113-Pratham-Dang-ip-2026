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
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println("  " + t);
            } else if (input.startsWith("unmark ")) {
                int taskNumber = Integer.parseInt(input.substring(7));
                Task t = tasks.get(taskNumber - 1);
                t.unmarkAsDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + t);
            } else {
                tasks.add(new Task(input));
                System.out.println("added: " + input);
            }
            input = sc.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}