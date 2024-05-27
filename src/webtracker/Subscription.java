package webtracker;

import java.time.LocalDateTime;
import java.time.Duration;

public class Subscription {
    private Website website;
    private Duration frequency;
    private LocalDateTime lastChecked;
    private String preferredChannel;

    public Subscription(String website, Duration frequency, String preferredChannel) {
        this.website = new Website(website);
        this.frequency = frequency;
        this.preferredChannel = preferredChannel;
        this.lastChecked = LocalDateTime.now();
    }

    public void setFrequency(Duration frequency) {
        this.frequency = frequency;
    }

    public void notifyUser() {
        Notification notification = new Notification();
        notification.sendNotification(this.preferredChannel);
    }

    public Website getWebsite() {
        return website;
    }

    public Duration getFrequency() {
        return frequency;
    }

    public LocalDateTime getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(LocalDateTime localDateTime) {
        this.lastChecked = localDateTime;
    }
}
