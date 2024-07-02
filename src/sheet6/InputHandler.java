package sheet6;

import java.util.*;

public class InputHandler {

    // map user email to user object, as email is unique
    private final Map<String, User> users = new HashMap<>(); // put, get, containsKey, remove
    private String currentUserEmail = "";

    public boolean createUser(String name, String email, String password) {
        if (!users.containsKey(email)) {
            users.put(email, new User(name, email, password));
            return true;
        } else {
            return false;
        }
    }

    public boolean validateUser(String email, String password) {
        User user = users.get(email);
        return (user != null) && (user.getPassword().equals(password));
    }

    public void setCurrentUserEmail(String email) {
        this.currentUserEmail = email;
    }

    public String getCurrentUserEmail() {
        return this.currentUserEmail;
    }

    public void handleUserInput(Scanner scanner) {
        System.out.print("Select: 1. Register 2. Login\n");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter email: ");
            String email = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            if (createUser(name, email, password)) {
                System.out.print("User created\n");
                setCurrentUserEmail(email);
            } else {
                System.out.print("User already exists\n");
            }
        } else if (choice == 2) {
            System.out.print("Enter email: ");
            String email = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            if (validateUser(email, password)) {
                setCurrentUserEmail(email);
            } else {
                System.out.println("Invalid login");
            }
        }
    }

    private void handleSubscriptionInput(Scanner scanner) {
        System.out.print("Select: 1. Add Subscription 2. Modify Frequency 3. Delete Subscription 4. Logout\n");
        int choice = scanner.nextInt();

        // get user from hashmap
        User user = users.get(getCurrentUserEmail());

        if (choice == 1) {
            System.out.print("Enter URL: ");
            String url = scanner.next();
            System.out.print("Enter frequency: ");
            int frequency = scanner.nextInt();
            if (user != null) {
                user.createSubscription(url, frequency, "Email");
            }
        } else if (choice == 2) {
            System.out.print("Enter URL: ");
            String url = scanner.next();
            System.out.print("Enter new frequency: ");
            int frequency = scanner.nextInt();
            if (user != null) {
                user.modifySubscription(url, frequency);
            }
        } else if (choice == 3) {
            System.out.print("Enter URL: ");
            String url = scanner.next();
            if (user != null) {
                user.deleteSubscription(url);
            }
        } else if (choice == 4) {
            setCurrentUserEmail("");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (getCurrentUserEmail().isEmpty()) {
                handleUserInput(scanner);
            } else {
                handleSubscriptionInput(scanner);
            }
        }
    }
}
