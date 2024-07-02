package sheet6.WebsiteComparison;

import org.jsoup.nodes.Document;

public class ContentSizeComparer implements IComparisonMethod {
    @Override
    public boolean compare(Document oldContent, Document newContent) {
        return oldContent.body().text().length() == newContent.body().text().length();
    }
}
