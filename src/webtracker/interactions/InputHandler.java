package webtracker.interactions;

import webtracker.main.WebsiteMonitor;

import java.util.Scanner;

public class InputHandler implements Runnable {
    private Integer stage = 1;
    private String currentUserEmail = "";
    private WebsiteMonitor websiteMonitor;

    public InputHandler(WebsiteMonitor websiteMonitor) {
        this.websiteMonitor = websiteMonitor;
    }

    // this is for handling login/registration
    private void stage1(Scanner scanner) {
        System.out.print("Select: 1. Register 2. Login\n");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter email: ");
            String email = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            websiteMonitor.createUser(name, email, password);
            this.currentUserEmail = email;
            this.stage = 2;
        } else if (choice == 2) {
            System.out.print("Enter email: ");
            String email = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            if (websiteMonitor.getUser(email).getPassword().equals(password)) {
                this.currentUserEmail = email;
                this.stage = 2;
            } else {
                System.out.println("Invalid login");
            }
        }
    }

    // this is for handling user input after login/registration
    private void stage2(Scanner scanner) {
        System.out.print("Select: 1. Add Subscription 2. Modify Frequency 3. Delete Subscription 4. Logout\n");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter URL: ");
            String url = scanner.next();
            System.out.print("Enter frequency: ");
            int frequency = scanner.nextInt();
            websiteMonitor.getUser(this.currentUserEmail).createSubscription(url, frequency, "Email");
        } else if (choice == 2) {
            System.out.print("Enter URL: ");
            String url = scanner.next();
            System.out.print("Enter new frequency: ");
            int frequency = scanner.nextInt();
            websiteMonitor.getUser(this.currentUserEmail).modifySubscription(url, frequency);
        } else if (choice == 3) {
            System.out.print("Enter URL: ");
            String url = scanner.next();
            websiteMonitor.getUser(this.currentUserEmail).deleteSubscription(url);
        } else if (choice == 4) {
            this.currentUserEmail = "";
            this.stage = 1;
        }
    }

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            switch (this.stage) {
                case 1:
                    this.stage1(scanner);
                    break;
                case 2:
                    this.stage2(scanner);
                    break;
                default:
                    break;
            }
        }

    }
}