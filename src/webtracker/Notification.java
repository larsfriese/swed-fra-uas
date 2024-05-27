package webtracker;

import java.util.Arrays;

public class Notification {

    private final String[] notifyChannels = {"Email", "Telegram"};
    private String[] notifyChannelsData = {};

    public Notification() {
        this.notifyChannelsData = new String[]{"", ""};
    }

    public void sendNotification(String channel) {
        System.out.println("Notification sent via " + channel);
        System.out.println(Arrays.toString(notifyChannelsData));
    }

}
