package sheet6;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Subscription implements Observer {
    private Duration frequency;
    private LocalDateTime lastNotified;
    private LocalDateTime lastChanged;
    private Notification notification;
    private Website websiteToObserve;
    private static List<Subscription> allSubscriptions = new ArrayList<>();

    public Subscription(String url, Duration frequency, String preferredChannel) {
        this.frequency = frequency;
        this.lastNotified = LocalDateTime.now();
        this.notification = new Notification(preferredChannel);
        allSubscriptions.add(this);
        checkForExistingWebsite(url);
    }

    public static List<Subscription> getAllSubscriptions() {
        return allSubscriptions;
    }

    public Website getWebsite() {
        return this.websiteToObserve;
    }

    public void setFrequency(Duration frequency) {
        this.frequency = frequency;
    }

    public void notifyUser() {
        notification.sendNotification("Website has changed: " + websiteToObserve.getUrl() + " at " + this.lastChanged);
    }

    public void checkForExistingWebsite(String url) {

        // check if website exists
        for (Website website : Website.getAllWebsites()) {
            if (website.getUrl().equals(url)) {
                this.websiteToObserve = website;

                // check if frequency is smaller than website frequency
                if (this.frequency.minus(website.getSmallestFrequency()).isNegative()) {
                    website.setSmallestFrequency(this.frequency);
                }

                return;
            }
        }

        // if website does not exist, create it
        Website website = new Website(url, frequency);
        this.websiteToObserve = website;
        website.attach(this);

    }

    @Override
    public void update() {
        this.lastChanged = this.websiteToObserve.getLastChanged();

        // if now - last notified > frequency
        if (LocalDateTime.now().isAfter(this.lastNotified.plus(this.frequency))) {
            notifyUser();
            this.lastNotified = LocalDateTime.now();
        }
    }
}
