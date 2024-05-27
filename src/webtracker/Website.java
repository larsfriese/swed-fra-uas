package webtracker;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;


public class Website {

    private String url = "";
    private byte[] lastMD5Sum = {};

    public Website(String url) {
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean hasChanged() {

        // get website html as string
        String content = null;
        try {
            URLConnection connection = null;
            URL urlObj =  URI.create(this.url).toURL();
            connection = urlObj.openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
        } catch (MalformedURLException e) {
            System.out.println("Not a valid URL.");
        } catch (IOException e) {
            System.out.println("Cannot connect to URL.");
        }

        // get md5 hash of html string
        byte[] currentMD5SUM = {};
        try {
            assert content != null;
            byte[] bytesOfHTML = content.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            currentMD5SUM = md.digest(bytesOfHTML);
        } catch (Exception e) {
            System.out.println("MD5 not found, or UTF-8 unsupported encoding.");
        }

        // compare md5 hash with last md5 hash
         if (!Arrays.equals(this.lastMD5Sum, currentMD5SUM)) {
             this.lastMD5Sum = currentMD5SUM;
             return true;
         } else {
             return false;
         }
    }

}
