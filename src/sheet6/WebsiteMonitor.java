package sheet6;

public class WebsiteMonitor {
    public static void main(String[] args) {

        // actual website monitor
        BackgroundWebChecker backgroundWebChecker = new BackgroundWebChecker();
        Thread backgroundThread = new Thread(backgroundWebChecker);
        backgroundThread.start();

        // run actual input handler in the main thread
        InputHandler inputHandler = new InputHandler();
        inputHandler.run();

    }
}
