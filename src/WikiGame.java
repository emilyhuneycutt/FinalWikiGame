import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class WikiGame {
    private int maxDepth;
    private ArrayList<String> path = new ArrayList<>();

    public static void main(String[] args) {
        WikiGame w = new WikiGame();
    }

    public WikiGame() {

        String startLink = "https://en.wikipedia.org/wiki/Barack_Obama";  // beginning link, where the program will start
        String endLink = "https://en.wikipedia.org/wiki/Honolulu";    // ending link, where the program is trying to get to

        maxDepth = 2;           // start this at 1 or 2, and if you get it going fast, increase

        if (findLink(startLink, endLink, 0)) {
            System.out.println("found it********************************************************************");
            path.add(startLink);
        } else {
            System.out.println("did not found it********************************************************************");
        }

    }

    // recursion method
    public boolean findLink(String startLink, String endLink, int depth) {

        System.out.println("depth is: " + depth + ", link is: https://en.wikipedia.org" + startLink);

        // BASE CASE
        if (startLink.equals(endLink)) {
            return true;
        } else if (depth == (maxDepth)) {

        }

        // GENERAL RECURSIVE CASE
        else {

            try {
                System.out.println();
                System.out.print("hello \n");
                // URL url = new URL("https://www.milton.edu/");
                URL url = new URL(startLink);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(url.openStream())
                );
                String line;
                while ( (line = reader.readLine()) != null ) {
                    if (line.contains("/wiki/")){
                        int start = line.indexOf("/wiki/");
                        int end = line.indexOf("\"", start);
                        String PartofLine = line.substring(start,end);
                        System.out.println("Links Found: " + PartofLine);
                        System.out.println("Link is: " + "https://en.wikipedia.org" + PartofLine);
//                    statusLabel.append("\n"+PartofLine);
                        if (findLink("https://en.wikipedia.org" + PartofLine,endLink,depth+1))
                        {
                            return true;
                        }

                    }

                }
                reader.close();
            } catch(Exception ex) {
                System.out.println("Error" + ex);
            }



        }

        return false;
    }
}
