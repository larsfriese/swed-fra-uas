import webtracker.Subscription;
import webtracker.User;
import webtracker.WebsiteMonitor;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        User user = new User("Max Mustermann", "musterman@gmail.com", "123");

        Duration duration = Duration.ofSeconds(2);
        Subscription subscription = new Subscription("http://127.0.0.1", duration, "Email");
        user.createSubscription(subscription);

        WebsiteMonitor websiteMonitor = new WebsiteMonitor();
        websiteMonitor.registerUser(user);

        while (true) {
            websiteMonitor.run();

            // sleep for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}