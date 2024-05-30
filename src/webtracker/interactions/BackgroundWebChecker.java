package webtracker.interactions;

import webtracker.main.WebsiteMonitor;

public class BackgroundWebChecker implements Runnable {
    private WebsiteMonitor websiteMonitor;

    public BackgroundWebChecker(WebsiteMonitor websiteMonitor) {
        this.websiteMonitor = websiteMonitor;
    }

    public WebsiteMonitor getWebsiteMonitor() {
        return this.websiteMonitor;
    }

    @Override
    public void run() {
        while (true) {
            this.websiteMonitor.run();

            // sleep for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}