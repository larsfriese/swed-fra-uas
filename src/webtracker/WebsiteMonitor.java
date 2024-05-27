package webtracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebsiteMonitor {
    private List<User> userList = new ArrayList<>();

    public void registerUser(User user) {
        userList.add(user);
    }

    public void run() {

        for (User user : this.userList) {
            user.checkSubscriptions();
        }

        System.out.println("checking...");
    }

}
