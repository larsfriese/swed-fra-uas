package sheet6.WebsiteComparison;

import org.jsoup.nodes.Document;

public class CompareContext {
    private IComparisonMethod compareMethod;

    public void setCompareMethod(IComparisonMethod compareMethod) {
        this.compareMethod = compareMethod;
    }

    public boolean compare(Document oldContent, Document newContent) {
        return compareMethod.compare(oldContent, newContent);
    }
}
