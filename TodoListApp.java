import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsDone();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting the program. Bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== Todo List Menu =====");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Done");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter the task: ");
        String taskDescription = scanner.nextLine();
        tasks.add(new Task(taskDescription));
        System.out.println("Task added: " + taskDescription);
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\n===== Tasks =====");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription() + " - " + (task.isDone() ? "Done" : "Not Done"));
            }
        }
    }

    private static void markTaskAsDone() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter the task number to mark as done: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                Task task = tasks.get(taskNumber - 1);
                task.setDone(true);
                System.out.println("Marked task as done: " + task.getDescription());
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    private static void deleteTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter the task number to delete: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                Task deletedTask = tasks.remove(taskNumber - 1);
                System.out.println("Deleted task: " + deletedTask.getDescription());
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    private static class Task {
        private String description;
        private boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getDescription() {
            return description;
        }

        public boolean isDone() {
            return isDone;
        }

        public void setDone(boolean done) {
            isDone = done;
        }
    }
}
