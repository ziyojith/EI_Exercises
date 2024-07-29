/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package creational_factory_pattern;

/**
 *
 * @author JITHIN V J
 */


interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

class NotificationFactory {
    public Notification createNotification(String notificationType) {
        switch (notificationType) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                return null;
        }
    }
}

// Usage
public class Creational_Factory_Pattern {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification notification = factory.createNotification("email");
        if (notification != null) {
            notification.send("Hello via Email!");
        }

        notification = factory.createNotification("sms");
        if (notification != null) {
            notification.send("Hello via SMS!");
        }

        notification = factory.createNotification("push");
        if (notification != null) {
            notification.send("Hello via Push Notification!");
        }
    }
}

