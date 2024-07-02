package sheet6.WebsiteComparison;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TextContentComparer implements IComparisonMethod {
    @Override
    public boolean compare(Document oldContent, Document newContent) {
        String oldText = Jsoup.parse(oldContent.html()).wholeText();
        String newText = Jsoup.parse(newContent.html()).text();
        System.out.println(oldContent);
        System.out.println(newContent);
        return oldText.equals(newText);
    }
}
