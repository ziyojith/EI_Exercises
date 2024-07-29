/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package astronautsdailyschedule;
import java.util.Scanner;

/**
 *
 * @author JITHIN V J
 */
public class AstronautsDailySchedule {

    /**
     * @param args the command line arguments
     */
  


    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter start time (HH:MM): ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter end time (HH:MM): ");
                    String endTime = scanner.nextLine();
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    Task task = TaskFactory.createTask(description, startTime, endTime, priority);
                    manager.addTask(task);
                    break;
                case "2":
                    System.out.print("Enter task description to remove: ");
                    description = scanner.nextLine();
                    manager.removeTask(description);
                    break;
                case "3":
                    manager.viewTasks();
                    break;
                case "4":
                    System.out.print("Enter task description to mark as completed: ");
                    description = scanner.nextLine();
                    manager.markTaskAsCompleted(description);
                    break;
                case "5":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

    

