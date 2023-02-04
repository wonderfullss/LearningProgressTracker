package Course;

import java.util.Scanner;

public class Menu {
    static Course a = new Course();
    static Scanner scan = new Scanner(System.in);

    public static void menu() {
        boolean flagMenu = true;
        System.out.println("Learning Progress Tracker");
        while (flagMenu) {
            String command = scan.nextLine();
            command = command.trim().toLowerCase();
            switch (command) {
                case "notify":
                    a.notifyStudents();
                    break;
                case "statistics":
                    a.statistics();
                    break;
                case "find":
                    a.find();
                    break;
                case "add points":
                    a.addPoints();
                    break;
                case "list":
                    a.list();
                    break;
                case "back":
                    System.out.println("Enter 'exit' to exit the program.");
                    break;
                case "exit": {
                    System.out.println("Bye!");
                    flagMenu = false;
                    break;
                }
                case "add students":
                    a.addStudents();
                    break;
                default: {
                    if (command.length() == 0) System.out.println("No input");
                    else System.out.println("Unknown command!");
                    break;
                }
            }
        }
    }
}
