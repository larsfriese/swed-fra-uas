package sheet6;

import java.time.LocalDateTime;
import java.util.List;

public class BackgroundWebChecker implements Runnable {

    public BackgroundWebChecker() {}

    @Override
    public void run() {
        do {
            // for each website, check if the smallest frequency has passed
            List<Website> websites = Website.getAllWebsites();
            for (Website website : websites) {
                if (LocalDateTime.now()
                        .isAfter(website.getLastChanged().plus(website.getSmallestFrequency()))) {
                    website.checkChange();
                }
            }

            // sleep for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }

}
