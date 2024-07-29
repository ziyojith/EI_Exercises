/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astronautsdailyschedule;

/**
 *
 * @author JITHIN V J
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScheduleManager {
    private static ScheduleManager instance = null;
    private ArrayList<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        if (isValidTask(task)) {
            tasks.add(task);
            Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
            System.out.println("Task added successfully. No conflicts.");
        } else {
            System.out.println("Error: Task conflicts with existing task or has invalid time format.");
        }
    }

    public void removeTask(String description) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void markTaskAsCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.markCompleted();
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Error: Task not found.");
    }

    private boolean isValidTask(Task newTask) {
        for (Task task : tasks) {
            if (isTimeConflict(task, newTask)) {
                return false;
            }
        }
        return true;
    }

    private boolean isTimeConflict(Task task, Task newTask) {
        return !(newTask.getEndTime().compareTo(task.getStartTime()) <= 0 ||
                 newTask.getStartTime().compareTo(task.getEndTime()) >= 0);
    }
}
