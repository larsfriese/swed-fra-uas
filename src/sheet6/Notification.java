package sheet6;

public class Notification {

    private String email;

    public Notification(String email) {
        this.email = email;
    }

    public void sendNotification(String message) {
        System.out.println("\n[Notifier] Email sent to " + this.email + " with message: " + message);
    }

}
