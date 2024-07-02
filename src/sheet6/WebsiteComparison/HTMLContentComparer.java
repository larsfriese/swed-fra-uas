package sheet6.WebsiteComparison;

import org.jsoup.nodes.Document;

public class HTMLContentComparer implements IComparisonMethod {
    @Override
    public boolean compare(Document oldContent, Document newContent) {
        return oldContent.equals(newContent);
    }
}
