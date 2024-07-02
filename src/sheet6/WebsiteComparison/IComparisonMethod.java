package sheet6.WebsiteComparison;

import org.jsoup.nodes.Document;

public interface IComparisonMethod {
    boolean compare(Document oldContent, Document newContent);
}
