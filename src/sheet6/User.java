package sheet6;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String password;
    private ArrayList<Subscription> subscriptionList;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscriptionList = new ArrayList<Subscription>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void createSubscription(String websiteUrl, Integer frequency, String notifyChannel) {
        for (Subscription subscription : subscriptionList) {
            if (subscription.getWebsite().equals(websiteUrl)) {
                throw new IllegalArgumentException("Subscription already exists");
            }
        }

        Subscription subscription = new Subscription(websiteUrl, Duration.ofSeconds(frequency), notifyChannel);
        subscriptionList.add(subscription);
    }

    public void modifySubscription(String websiteUrl, Integer frequency) {
        for (Subscription subscription : subscriptionList) {
            if (subscription.getWebsite().getUrl().equals(websiteUrl)) {
                subscription.setFrequency(Duration.ofSeconds(frequency));
                return;
            }
        }
        throw new IllegalArgumentException("Subscription does not exist");
    }

    public void deleteSubscription(String websiteUrl) {
        for (Subscription subscription : subscriptionList) {
            if (subscription.getWebsite().getUrl().equals(websiteUrl)) {
                subscriptionList.remove(subscription);
                return;
            }
        }
        throw new IllegalArgumentException("Subscription does not exist");
    }
}