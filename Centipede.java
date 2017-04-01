import java.util.Scanner;

public class Centipede {
	
	// Change the array size to how many pages you want to search
	// Future change to facilitate the use of an ArrayList
	public String[] urlArray = new String[10];
	public String keyword;
	public static int numPages = 0;
	public static int pagesSearched = 0;
	public static String fake = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
	

	// No arg constructor to create Centipedes
	Centipede(){
		
	}
	

	// Grab URLs from the user and add them to the
	// array. No error checking. Don't make mistakes.
	public void addUrl(Scanner input){
		System.out.print("Add a url to the array: ");
		urlArray[numPages] = input.nextLine();
		numPages++;
	}
	

	// Grabs the next URL and gives it to *****************
	public String nextPage(){
		
		String next = urlArray[pagesSearched];
		pagesSearched++;
		return next;
	}
	

	// Setter for the keyword
	public void setKeyword(String key){
		this.keyword = key;
	}
	
}
