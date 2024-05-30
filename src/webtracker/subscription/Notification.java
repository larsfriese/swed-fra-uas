package webtracker.subscription;

public class Notification {

    private String email;

    public Notification(String email) {
        this.email = email;
    }

    public void sendNotification(String message) {
        System.out.println("\n[Notifier] Email sent to " + email + " with message: " + message);
    }

}
