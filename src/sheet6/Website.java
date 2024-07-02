package sheet6;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import sheet6.WebsiteComparison.CompareContext;
import sheet6.WebsiteComparison.TextContentComparer;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Website extends Subject {

    private String url;
    private Document currentContent;
    private CompareContext compareContext;
    private static List<Website> allWebsites = new ArrayList<>();

    // this is the "state" from the observer pattern
    private LocalDateTime lastChanged;

    // the smallest frequency specified by a subscription for this website
    private Duration smallestFrequency;

    public Website(String url, Duration smallestFrequency) {
        this.url = url;
        this.compareContext = new CompareContext();
        this.lastChanged = LocalDateTime.now();
        this.smallestFrequency = smallestFrequency;
        allWebsites.add(this);
    }

    // getter for the static list of all websites
    public static List<Website> getAllWebsites() {
        return allWebsites;
    }

    // this function represents the "getState" from the observer pattern
    public LocalDateTime getLastChanged() {
        return lastChanged;
    }

    public Object getUrl() {
        return this.url;
    }
    public Duration getSmallestFrequency() {
        return smallestFrequency;
    }
    public void setSmallestFrequency(Duration smallestFrequency) {
        this.smallestFrequency = smallestFrequency;
    }

    public boolean checkChange() {

        // get website html as string using jsoup
        Document newContent;
        try {
            newContent = Jsoup.connect(this.url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // the first time we check the website,
        // we don't have a previous content to compare with
        if (this.currentContent == null) {
            this.currentContent = newContent;
            return false;
        }

        // compare contents with specified method
        compareContext.setCompareMethod(new TextContentComparer());
        boolean result = compareContext.compare(newContent, this.currentContent);
        if (!result) {
            this.currentContent = newContent;
            this.lastChanged = LocalDateTime.now();
            notifyObservers();
        }
        return result;
    }
}
