package webtracker.main;

import java.util.ArrayList;
import java.util.List;

public class WebsiteMonitor {
    private List<User> userList = new ArrayList<>();

    public void createUser(String name, String email, String password) {
        User newUser = new User(name, email, password);
        userList.add(newUser);
    }

    public User getUser(String email) {
        for (User user : this.userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void run() {

        for (User user : this.userList) {
            user.checkSubscriptions();
        }

    }

}
