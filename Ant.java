import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Ant{
 
	//This method gets the URLs the user wants to search for via user input
	public static void getURLS(Scanner input, Centipede object){
		char ans;
		System.out.print("Do you want to enter URLs?");
		ans = input.next().charAt(0);
		input.nextLine();
		
		if(ans == 'y'){
			while(ans == 'y'){
				input.nextLine();
				object.addUrl(input);
				System.out.print("Would you like to add another 'y' or 'n'");
				ans = input.next().charAt(0);
			}
		}
	}
	
	//This method sets the keyword via user input
	public static void getKeyword(Scanner input, Centipede object){
		String keyword;
		System.out.print("Enter a keyword you wish to search for: ");
		keyword = input.next();
		object.setKeyword(keyword);
	}

	
	
	public static boolean crawl(String url, Centipede object){
		
		//Tries to open the webpage. If successful pulls all content from the body and 
		//then checks to see if the keyword is located within it.
        try{
            Connection connection = Jsoup.connect(url).userAgent(object.fake);
            Document htmlDocument = connection.get();
            // 200 is the HTTP OK status code look up other status codes later           
            if(connection.response().statusCode() == 200){
                System.out.println("\n**Visiting** Received web page at " + url);
                Elements elements = htmlDocument.select("body").first().children();
        		System.out.println("Searching for the word " + object.keyword + "...");
                String bodyText = htmlDocument.body().text();
                return bodyText.toLowerCase().contains(object.keyword.toLowerCase());
                
            }
            if(!connection.response().contentType().contains("text/html"))
            {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            return true;
        }
        catch(IOException ioe){
            // Did not get the webpage
            return false;
        }
        catch(IllegalArgumentException iae){
        	// We didn't enter the webpage correctly?
        	return false;
        }
    }
	

}
