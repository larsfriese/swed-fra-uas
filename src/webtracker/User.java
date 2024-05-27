package webtracker;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private List<Subscription> subscriptionList;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscriptionList = new ArrayList<Subscription>();
    }

    public void createSubscription(Subscription subscription) {
        subscriptionList.add(subscription);
    }

    public void removeSubscription(Subscription subscription) {
        subscriptionList.remove(subscription);
    }

    public void changeSubscriptionFrequency(Subscription subscription, Duration frequency) {
        subscription.setFrequency(frequency);
    }

    public void checkSubscriptions() {
        LocalDateTime localDateTime = LocalDateTime.now();
        for (Subscription subscription : subscriptionList) {

            // if now - lastChecked > frequency
            if (localDateTime.isAfter(subscription.getLastChecked().plus(subscription.getFrequency()))) {

                if (subscription.getWebsite().hasChanged()) {
                    subscription.notifyUser();
                    subscription.setLastChecked(localDateTime);
                }
            }
        }
    }
}
