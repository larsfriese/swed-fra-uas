// In Main.java
import webtracker.main.WebsiteMonitor;
import webtracker.interactions.BackgroundWebChecker;
import webtracker.interactions.InputHandler;

public class Main {
    public static void main(String[] args) {
        WebsiteMonitor websiteMonitor = new WebsiteMonitor();

        // webcheck thread
        Runnable websiteChecker = new BackgroundWebChecker(websiteMonitor);
        Thread websiteCheckerThread = new Thread(websiteChecker);
        websiteCheckerThread.start();

        // user input
        Runnable userInputHandler = new InputHandler(websiteMonitor);
        Thread userInputHandlerThread = new Thread(userInputHandler);
        userInputHandlerThread.start();
    }
}