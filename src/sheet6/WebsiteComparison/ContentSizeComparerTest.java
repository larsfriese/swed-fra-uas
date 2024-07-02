package sheet6.WebsiteComparison;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ContentSizeComparerTest {

    private ContentSizeComparer testClass;

    @Before
    public void setUp() {
        testClass = new ContentSizeComparer();
    }

    @Test
    public void compareContentSize() {
        Document doc1 = Jsoup.parse("null");
        Document doc2 = Jsoup.parse("<p>null</p>");
        assertTrue(testClass.compare(doc1, doc2));
    }

}