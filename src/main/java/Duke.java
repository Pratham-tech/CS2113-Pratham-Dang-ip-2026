import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Pratbot.\nWhat can I do for you?");
        ArrayList<String> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("bye")) {
            if (input.equals("list")) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            } else {
                tasks.add(input);
                System.out.println("added: " + input);
            }
            input = sc.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
